package sam.googleOAuth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@Slf4j
public class GoogleOAuthApplication {


    public static void main(String[] args) {
        SpringApplication.run(GoogleOAuthApplication.class, args);
    }

    /*
    1. Below is the API which get redirected after successful sign in.
    2. For testing, I've created client id, secret key using official email id.
    */
    @GetMapping
    public String welcome() {
        return "Welcome";
    }


    // Below API return the principal details of the registered/signed-in user.
    @GetMapping("/principal")
    public Principal welcomeUser(Principal principal) {
        log.info("User: " + principal.getName());
        return principal;
    }

}
