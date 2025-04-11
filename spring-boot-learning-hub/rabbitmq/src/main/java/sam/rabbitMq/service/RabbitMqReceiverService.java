package sam.rabbitMq.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqReceiverService {

    @RabbitListener(queues = "multiplesOfFiveQueue")
    public void receiveMultiplesOfFive(int multipleOfFive) {
        System.out.println("Multiple of 5 received from RabbitMQ: " + multipleOfFive);
    }
}

