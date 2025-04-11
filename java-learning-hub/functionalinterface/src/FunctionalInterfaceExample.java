import java.util.function.*;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Predicate takes one argument and return boolean.
        Predicate<Integer> oddPredicate = digit -> digit % 2 != 0;
        Predicate<String> stringPredicate = digit -> digit.matches(".*[azAZ].*");
        System.out.println(oddPredicate.test(1));
        System.out.println(stringPredicate.test("aBcD"));

        // Function takes one argument and return a result of desired type.
        Function<Integer, Integer> integerIntegerFunction = (num) -> num * num;
        System.out.println("The result of integer function: " + integerIntegerFunction.apply(5));

        Function<String, Integer> stringIntegerFunction = String::length;
        System.out.println("The result of string function: " + stringIntegerFunction.apply("SamPaul Isaac"));

        // Bi function accepts two arguments and return a result of desired type.
        BiFunction<Integer, Integer, Integer> integerIntegerBiFunction = (num1, num2) -> num1 * num2;
        System.out.println("The result of integer bi function: " + integerIntegerBiFunction.apply(5, 7));

        // Consumer takes a single argument and doesn't return a result
        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("Sampaul Issac");

        Consumer<Integer> integerConsumer = (intValue) -> Math.pow(intValue, intValue);
        integerConsumer.accept(5);

        //Supplier - return results.
        Supplier<Double> integerSupplier = Math::random;
        System.out.println("The result of supplier: " +  integerSupplier.get());


    }
}
