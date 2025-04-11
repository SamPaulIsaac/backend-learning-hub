import java.util.Comparator;
import java.util.List;

public class General {
    public static void main(String[] args) {
        List<String> list1 = List.of("Alice", "Bob", "Charlie");
        System.out.println(list1.stream().sorted(Comparator.reverseOrder()).toList());
    }
}
