import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println("Word Pattern: " + solution(pattern, s));
    }

    public static boolean solution(String pattern, String s) {
        String[] str = s.split(" ");
        if (pattern.length() != str.length) return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currentPattern = pattern.charAt(i);
            String currentString = str[i];
            if (map.containsKey(currentPattern)) {
                if (!Objects.equals(map.get(currentPattern), currentString)) return false;
            } else {
                if (map.containsValue(currentString)) return false;
                map.put(currentPattern, currentString);
            }
        }

        return true;
    }
}
