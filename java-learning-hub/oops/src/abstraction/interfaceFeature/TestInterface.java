package abstraction.interfaceFeature;

interface Shape {

    int v = 10;

    static String get() {
        return "static";
    }

    String returnShape();

    String returnShape2();

    default void firstDefaultMethod() {
        System.out.println("This method is final and cannot be overridden.");
    }

    default void secondDefaultMethod() {
        System.out.println("This method is final and cannot be overridden.");
    }
}

public class TestInterface {
    public static void main(String[] args) {
        ImplementingClass obj1 = new ImplementingClass(3);
        System.out.println("SHAPE CAN BE: " + obj1.returnShape());
        obj1.firstDefaultMethod();
        obj1.secondDefaultMethod();


        Shape shape = new Shape() {
            @Override
            public String returnShape() {
                return "sam";
            }

            @Override
            public String returnShape2() {
                return "sampaul";
            }
        };

        System.out.println(shape.returnShape());
    }
}

class ImplementingClass implements Shape {

    private final Integer side;

    public ImplementingClass(Integer side) {
        this.side = side;
    }

    public Integer getSide() {
        return side;
    }

    @Override
    public String returnShape() {
        String shape = "";
        if (getSide() == 4) {
            shape = "RECTANGLE";
        } else if (getSide() == 3) {
            shape = "TRIANGLE";
        } else if (getSide() == 2) {
            shape = "POLYGON";
        } else if (getSide() == 1) {
            shape = "LINE";
        } else if (getSide() == 0) {
            shape = "POINT";
        } else {
            shape = "NO SHAPE";
        }
        return shape;
    }

    @Override
    public String returnShape2() {
        return "test";
    }

    ;

    @Override
    public void firstDefaultMethod() {
        System.out.println("HELLO.");
    }

    @Override
    public void secondDefaultMethod() {
        System.out.println("HEY");
    }

}
