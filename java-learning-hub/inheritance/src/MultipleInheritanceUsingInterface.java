interface interfaceA {

    default void test() {
        System.out.println("Response from interface A.");
    }
}

interface interfaceB {
    default void test() {
        System.out.println("Response from interface b.");
    }
}

class classCTestInterface implements interfaceA, interfaceB {
    public void test() {
        System.out.println("Test from class C.");
    }
}

public class MultipleInheritanceImplementationUsingInterface {
    public static void main(String[] args) {
        classCTestInterface c = new classCTestInterface();
        c.test();
    }
}
