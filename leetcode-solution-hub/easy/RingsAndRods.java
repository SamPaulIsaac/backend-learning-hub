import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsAndRods {
    public static void main(String[] args) {

        String rings = "B0B6G0R6R0R6G9";
        Map<Character, Set<Character>> result = new HashMap<>();

        for (int i = 1; i < rings.length(); i = i + 2) {
            Set<Character> set = result.getOrDefault(rings.charAt(i), new HashSet<>());
            set.add(rings.charAt(i - 1));
            result.put(rings.charAt(i), set);
        }
        int occurrence = 0;
        for (Map.Entry<Character, Set<Character>> entry : result.entrySet()) {
            if ((entry.getValue()).size() == 3) occurrence++;
        }

        System.out.println(occurrence);
    }
}
