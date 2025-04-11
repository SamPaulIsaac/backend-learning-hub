import java.util.HashMap;
import java.util.Map;

public class DecryptStringFromAlphabet {
    public static void main(String[] args) {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"; //10#11#12
        //String s = "10#11#12";
        //String s = "26#11#418#5";
        Map<Integer, Character> characterMap = new HashMap<>();
        for (int i = 1; i <= 26; i++)
            characterMap.put(i, (char) ('a' + i - 1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int value = Integer.parseInt(s.substring(i, i + 2));
                sb.append(characterMap.get(value));
                i += 2;

            } else {
                sb.append(characterMap.get(Character.getNumericValue(currentChar)));
            }
        }
        System.out.println("RESULT: " + sb);
    }
}
