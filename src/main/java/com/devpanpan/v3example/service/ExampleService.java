package com.devpanpan.v3example.service;

import com.devpanpan.v3example.dto.ExampleDto;
import com.devpanpan.v3example.entity.Example;
import com.devpanpan.v3example.repository.ExampleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleRepository exampleRepository;

    @PostConstruct
    private void addDummyData() {
        var entityCount = exampleRepository.count();
        if (entityCount == 0) {
            var exampleList = Arrays.asList(
                    Example.builder().id(1).content("예시 1번 데이터").build(),
                    Example.builder().id(2).content("예시 2번 데이터").build()
            );
            exampleRepository.saveAll(exampleList);
        }
    }

    public ExampleDto get(long id) {
        var example = exampleRepository.findById(id).orElseThrow();
        return ExampleDto.builder()
                .id(example.getId())
                .content(example.getContent())
                .build();
    }

}
