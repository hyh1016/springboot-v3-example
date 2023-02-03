package com.devpanpan.v3example.controller;

import com.devpanpan.v3example.dto.ExampleDto;
import com.devpanpan.v3example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/{id}")
    public ExampleDto get(@PathVariable long id) {
        return exampleService.get(id);
    }

}
