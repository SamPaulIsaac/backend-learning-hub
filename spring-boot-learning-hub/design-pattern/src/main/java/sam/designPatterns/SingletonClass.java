package sam.designPatterns;


import org.springframework.stereotype.Component;

@Component
public class SingletonClass {
    private static SingletonClass instance;

    private SingletonClass() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@TESTING!!!!!!!!@@@@@@@@");
    }

    public static SingletonClass getInstance() {
        System.out.println("INSIDE 1");
        if (instance == null) {
            System.out.println("INSIDE 2");
            instance = new SingletonClass();
        }
        System.out.println("INSIDE 3");
        return instance;
    }
}
