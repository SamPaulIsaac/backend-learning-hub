package sam.rabbitMq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSenderService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMultiplesOfFive() {
        for (int i = 1; i <= 10; i++) {
            int multipleOfFive = i * 5;
            amqpTemplate.convertAndSend("multiplesOfFiveQueue", multipleOfFive);
        }
        System.out.println("Completed sending of multiples of 5");

    }
}

