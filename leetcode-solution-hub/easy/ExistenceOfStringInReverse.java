import java.util.HashMap;
import java.util.Map;

public class ExistenceOfStringInReverse {
    public static void main(String[] args) {
        String input = "abcb";
        System.out.println(Solution(input));
    }

    public static Boolean Solution(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length() - 1; i++) {
            map.put(input.substring(i, i + 2), i);
        }
        for (int j = 0; j < stringBuilder.length() - 1; j++) {
            if (map.containsKey(stringBuilder.substring(j, j + 2))) {
                return true;
            }
        }
        return false;
    }
}
