package private_demo.private_package2;

import private_demo.private_package1.Sample1Private;

public class privateDemoApplication {
    public static void main(String[] args) {
        Sample1Private sample = new Sample1Private();
        /*
        Below attributes cannot be accessed.
         */
//        sample.id = 5;
//        sample.value = "test";
//        System.out.println(sample.id);
//        System.out.println(sample.value);
//        sample.testMethod();
    }
}
