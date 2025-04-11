package com.sam.retryMechanism.controller;

import com.sam.retryMechanism.service.RetryMechanismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retryMechanism")
public class RetryMechanismController {

    @Autowired
    private RetryMechanismService retryMechanismService;

    @GetMapping("/test")
    public void testRetryMechanism(){
        retryMechanismService.testRetryMechanism();
    }
}
