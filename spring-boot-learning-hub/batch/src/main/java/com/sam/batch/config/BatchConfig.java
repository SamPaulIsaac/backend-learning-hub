package com.sam.batch.config;

import com.sam.batch.entity.Payment;
import com.sam.batch.repository.PaymentRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;


    @Bean
    public JobExecutionListener jobExecutionListener() {
        return new PaymentJobExecutionListener();
    }

    @Bean
    public FlatFileItemReader<Payment> reader() {
        FlatFileItemReader<Payment> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("payments.csv"));
        reader.setLinesToSkip(1);

        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setDelimiter(DELIMITER_COMMA);
                setNames("amount", "paymentMethod");
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(Payment.class);
            }});
        }});

        reader.setRecordSeparatorPolicy(new BlankLineRecordSeparatorPolicy());
        return reader;
    }

    @Bean
    public ItemProcessor<Payment, Payment> processor() {
        return payment -> {
            return payment;
        };
    }

    @Bean
    public ItemWriter<Payment> writer() {
        return payments -> {
            System.out.println("Saving Invoice Records: " + payments);
            paymentRepository.saveAll(payments);
        };
    }

    @Bean
    public Step stepSequence() {
        return new StepBuilder("csv-step", jobRepository).<Payment, Payment>chunk(2, platformTransactionManager).reader(reader()).processor(processor()).writer(writer()).build();
    }

    @Bean
    public Job runJob() {
        return new JobBuilder("job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(jobExecutionListener())
                .start(stepSequence())
                .build();
    }
}
