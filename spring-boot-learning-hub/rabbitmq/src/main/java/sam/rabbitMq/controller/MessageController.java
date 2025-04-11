package sam.rabbitMq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.rabbitMq.service.RabbitMqSenderService;

@RestController
@RequestMapping("/api/rabbitMq")
public class MessageController {

    @Autowired
    private RabbitMqSenderService senderService;

    @PostMapping("/sendMultiplesOfFive")
    public String sendMultiplesOfFive() {
        senderService.sendMultiplesOfFive();
        return "Multiples of 5 sent to RabbitMQ";
    }
}

