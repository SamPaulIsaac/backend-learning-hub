package public_demo.pub_package1;

public class Sample1Public {
    public int id;
    public String value;

    public void testMethod() {
        System.out.println("This is a test method of the sample class which is used as part of public demo app.");
        System.out.println(STR."Values/attributes are: \{id}, \{value}");
        testPrivateMethod();
    }

    private void testPrivateMethod() {
        System.out.println("This can be invoked only within the class.");
    }
}
