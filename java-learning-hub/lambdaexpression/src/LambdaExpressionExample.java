@FunctionalInterface
interface SamInterface {
    static void staticMethod() {
        System.out.println("Static method is invoked!");
    }

    void play(String name);

    default void play() {
        System.out.println("Play started!");
    }
}

public class LambdaExpressionExample implements SamInterface {
    public static void main(String[] args) {
        //SamInterface.staticMethod();

        // Before Lambda Expression
        LambdaExpressionExample obj = new LambdaExpressionExample();
        obj.play("sam");

        // Lambda Expression Implementation - concise way of implementing sam in functional interface using expression(s).
        SamInterface anInterface = (name) -> System.out.println("Play started," + name);
        anInterface.play("sam");
        anInterface.play();
    }

    @Override
    public void play(String name) {
        System.out.println("Play started by: " + name);
    }
}
