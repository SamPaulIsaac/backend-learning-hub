package abstraction.abstractFeature;

abstract class SampleAbstract {

    private int a = 19;

    static String test3() {
        return "Static";
    }

    public int getA() {
        return a;
    }

    abstract String testMethod1();

    final String dei() {
        return "DEI";
    }

    protected String test2() {
        return "test";
    }
}

class ExtendingAbstractClass extends SampleAbstract {
    @Override
    String testMethod1() {
        return "Overridden testMethod1";
    }

    @Override
    protected String test2() {
        return "Method test2dsfbjkdaj;fljg.";
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        ExtendingAbstractClass extendingAbstractClass = new ExtendingAbstractClass();
        System.out.println(extendingAbstractClass.testMethod1());
        System.out.println(extendingAbstractClass.test2());
        System.out.println(SampleAbstract.test3());
        System.out.println(extendingAbstractClass.getA());
        System.out.println(extendingAbstractClass.dei());
    }
}