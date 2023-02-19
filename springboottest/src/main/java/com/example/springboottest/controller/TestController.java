package com.example.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottest.dto.TestDto;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping(value="/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping(value="/test")
    public TestDto test(@RequestBody TestDto dto) {
        return dto;
    }
}
