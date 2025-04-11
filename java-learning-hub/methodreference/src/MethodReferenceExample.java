import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        List<String> result = strings.stream().filter(ValidateString::startsWithCapital).toList();
        System.out.println("Result: " + result);

        // Static Method Reference
        Function<String, Integer> stringLength1 = String::length;
        System.out.println(stringLength1.apply("Hello"));

        // Instance Method Reference
        String test = "This is a test String.";
        Function<String, String> concatMethod = test::concat;
        System.out.println(concatMethod.apply("add"));

        //Instance Method Reference on an Arbitrary Object
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Sort list using instance method reference on an arbitrary object.s
        // arbitrary object - String
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);  // Outputs: [Alice, Bob, Charlie]
    }
}

class ValidateString {
    public static boolean startsWithCapital(String str) {
        return str.matches("^[a].*");
    }
}
