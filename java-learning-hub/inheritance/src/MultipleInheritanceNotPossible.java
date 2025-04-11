class classA {
    public void test() {
        System.out.println("Test from clas A.");
    }
}

class classB extends classA {
    public void test() {
        super.test();
        System.out.println("Test from class B.");
    }
}

class classC extends classB {
    public void test() {
        super.test();
        System.out.println("Test from class C.");
    }
}

public class MultipleInheritanceNotPossible {
    public static void main(String[] args) {
        classC c = new classC();
        c.test();
    }
}
