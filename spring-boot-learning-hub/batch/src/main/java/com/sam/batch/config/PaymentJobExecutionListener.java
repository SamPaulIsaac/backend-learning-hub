package com.sam.batch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

@Slf4j
public class PaymentJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("-----BEFORE JOB-----");
        log.info("Before - Job is starting at: {}", jobExecution.getStartTime());
        log.info("Before - Job Id: {}", jobExecution.getJobId());
        log.info("Before - Job status: {}", jobExecution.getStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("-----AFTER JOB-----");
        log.info("After - Job is starting at: {}", jobExecution.getStartTime());
        log.info("After - Job Id: {}", jobExecution.getJobId());
        log.info("After - Job status: {}", jobExecution.getStatus());
        log.info("After - Job End Time: {}", jobExecution.getEndTime());
    }
}
