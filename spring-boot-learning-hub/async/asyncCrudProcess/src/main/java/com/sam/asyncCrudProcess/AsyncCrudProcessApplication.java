package com.sam.asyncCrudProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncCrudProcessApplication {

	public static void main(String[] args) {

		System.out.println("Async Crud Process Application.");
		SpringApplication.run(AsyncCrudProcessApplication.class, args);
	}

}
