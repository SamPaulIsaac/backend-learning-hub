package com.sam.redis.controller;

import com.sam.redis.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/basicRedis/")
public class BasicController {

    @Autowired
    private BasicService basicService;

    @GetMapping("/get/{input}")
    public String get(@PathVariable String input) {
        return basicService.performOperation(input);
    }
}
