package sam.designPatterns;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SingletonController {

    private final SingletonClass singletonClass;

    @GetMapping("/singleton")
    public String getSingleton() {

        System.out.println("CHECK: " + SingletonClass.getInstance());
        return "This is a singleton instance: " + singletonClass.toString();
    }

}
