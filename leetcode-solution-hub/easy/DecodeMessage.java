import java.util.LinkedHashMap;
import java.util.Map;

public class DecodeMessage {
    public static void main(String[] args) {
        Map<Character, Character> map = new LinkedHashMap<>();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        char initial = 'a';
        for (int i = 0; i < key.length(); i++) {
            char current = key.charAt(i);
            if (!map.containsKey(current) && current != ' ') {
                map.put(current, initial);
                initial++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ')
                stringBuilder.append(c);
            else
                stringBuilder.append(map.get(c));
        }
        System.out.println("SB: " + stringBuilder);
        String sam = "SaM";
        System.out.println(sam.toLowerCase());
    }
}

