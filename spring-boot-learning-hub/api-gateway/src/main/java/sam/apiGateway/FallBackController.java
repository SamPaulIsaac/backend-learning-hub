package sam.apiGateway;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/orderFallBack")
    public String orderServiceFallBack() {
        return "Order Service is down!";
    }

    @GetMapping("/paymentFallBack")
    public String paymentServiceFallBack() {
        return "Payment Service is down!";
    }
}
