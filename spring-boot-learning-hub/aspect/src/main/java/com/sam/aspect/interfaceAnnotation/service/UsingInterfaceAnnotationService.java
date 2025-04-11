package com.sam.aspect.interfaceAnnotation.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsingInterfaceAnnotationService {

    public List<String> getData() {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            stringList.add("Record " + i);
        return stringList;
    }
}
