package com.sam.aspect.pointcut.controller;

import com.sam.aspect.pointcut.service.UsingPointcutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aspect/pointcut")
@AllArgsConstructor
public class UsingPointcutController {
    private UsingPointcutService service;

    @GetMapping("/getData")
    public List<String> getData() {
        List<String> response = service.getData();
        return response;
    }
}
