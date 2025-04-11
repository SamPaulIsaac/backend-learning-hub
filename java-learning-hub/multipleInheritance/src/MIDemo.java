class A {
    public void display() {
        System.out.println("Hello from A!");
    }
}

class B extends A {
    public void display() {
        System.out.println("Hello from B!");
    }
}

class C extends A {
    public void display() {
        System.out.println("Hello from C!");
    }
}

/*

    Java doesn't support multiple inheritance due to diamond problem.
    The situation where the compiler would not be able to decide which method to inherit from!
 */
//class D extends B,A {
//
//}


/*
    To avoid this, there is another route.
    The same multiple inheritance can be achieved using interface.
 */

interface I {
    default void display() {
        System.out.println("Hello from I!.");
    }

    void testI1();
}

interface J {
    default void display() {
        System.out.println("Hello from J!.");
    }

    void testI1();

}

class ImplementingClass implements I, J {

    @Override
    public void display() {
        I.super.display();
        J.super.display();

        System.out.println("Hello from Implementing Class!");
    }

    @Override
    public void testI1() {
        System.out.println("Hello from Implementing class - testI1 ");
    }
}

public class MIDemo {
    public static void main(String[] args) {
        ImplementingClass obj = new ImplementingClass();
        obj.display();
    }
}