import java.util.function.BiFunction;

public class LambdaExpression {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> (a + b - 3) * 7;
        System.out.println("Sum of 2 numbers: " + add.apply(5, 7));
    }

}