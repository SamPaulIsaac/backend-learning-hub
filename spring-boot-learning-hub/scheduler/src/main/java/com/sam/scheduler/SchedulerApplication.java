package com.sam.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }

    /*
    @Scheduled(fixedRate = 2000) // Run every 2 seconds
    @Scheduled(fixedDelay = 2000) // // Run every 2 seconds after the completion of the previous execution
    @Scheduled(cron = "0 0 12 * * ?") // Run every day at 12:00 PM
    -- second
    -- minute
    -- hour
    -- Day of month
    -- Month
    -- Day of week
*/
    @Scheduled(cron = "* * * * * ?")
    public void notification() {
        System.out.println("Scheduled task executed at: " + LocalDateTime.now());
    }
}
