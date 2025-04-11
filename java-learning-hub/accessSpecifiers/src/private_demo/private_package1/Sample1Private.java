package private_demo.private_package1;

public class Sample1Private {
    private int id;
    private String value;

    private void testPrivateMethod() {
        System.out.println("This can be invoked only within the class.");
        System.out.println(STR."Values/attributes are: \{id}, \{value}");
    }
}
