package com.sam.retryMechanism.service;

import lombok.AllArgsConstructor;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RetryMechanismService {
    private final RetryTemplate retryTemplate;
    private final RestTemplate restTemplate;
    private final String url = "https://api.example.com/data";

    public void testRetryMechanism() {
        retryTemplate.execute(context -> {
            System.out.println("URL: " + url + " " + "attempt no: " + (context.getRetryCount() + 1));
            System.out.println("Time now: "+ LocalDateTime.now());
            return restTemplate.getForObject(url, String.class);
        });

    }
}
