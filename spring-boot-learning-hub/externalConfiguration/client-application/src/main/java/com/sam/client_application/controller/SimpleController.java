package com.sam.client_application.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleController {

    @Value("${message.info}")
    private String message;

    @GetMapping("/getMessage")
    public String getMessage(){
        return message;
    }
}
