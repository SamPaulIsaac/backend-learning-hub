package sam.rabbitMq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue multiplesOfFiveQueue() {
        return new Queue("multiplesOfFiveQueue", true, false, false);
    }
}

