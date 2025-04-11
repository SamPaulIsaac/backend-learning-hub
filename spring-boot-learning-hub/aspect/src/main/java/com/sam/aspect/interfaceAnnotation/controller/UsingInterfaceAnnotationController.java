package com.sam.aspect.interfaceAnnotation.controller;

import com.sam.aspect.interfaceAnnotation.config.LogExecutionTime;
import com.sam.aspect.interfaceAnnotation.service.UsingInterfaceAnnotationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aspect/interface")
@AllArgsConstructor
public class UsingInterfaceAnnotationController {
    private UsingInterfaceAnnotationService usingInterfaceAnnotationService;

    @GetMapping("/getData")
    @LogExecutionTime
    public List<String> getData() {
        List<String> response = usingInterfaceAnnotationService.getData();
        return response;
    }
}
