package public_demo.pub_package2;

import public_demo.pub_package1.Sample1Public;

public class PublicDemoApplication {
    public static void main(String[] args) {
        Sample1Public sample = new Sample1Public();
        sample.id = 5;
        sample.value = "test";
        System.out.println(sample.id);
        System.out.println(sample.value);
        sample.testMethod();
    }
}
