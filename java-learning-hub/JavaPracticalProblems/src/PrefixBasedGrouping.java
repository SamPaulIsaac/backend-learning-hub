import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixBasedGrouping {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Adam", "Bob", "Bella", "Charlie", "Chloe");
        Map<Character, List<String>> result = new HashMap<>();
        for (String s : names) {
            char c = s.charAt(0);
//            if (result.get(c) != null) result.get(c).add(s);
//            else result.put(c, new ArrayList<>(List.of(s)));
            result.computeIfAbsent(c,k-> new ArrayList<>(List.of(s))).add(s);
        }
        System.out.println("Resultant map: " + result);
    }
}
