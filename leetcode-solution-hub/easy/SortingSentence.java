import java.util.HashMap;
import java.util.Map;

public class SortingSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        String[] strings = s.split(" ");
        Map<Integer, String> map = new HashMap<>();
        for (String string : strings) {
            int length = string.length() - 1;
            char c = string.charAt(length);
            map.put((int) c, string.substring(0, length));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String value : map.values()) stringBuilder.append(value).append(" ");
        System.out.println(stringBuilder.toString().trim());
    }
}
