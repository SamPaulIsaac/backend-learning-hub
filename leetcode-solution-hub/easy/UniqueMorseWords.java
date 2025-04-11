import java.util.HashSet;
import java.util.Set;

public class UniqueMorseWords {
    public static void main(String[] args) {
        String[] string = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] words = {"gin", "zen", "gig", "msg"};
        Set<String> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.setLength(0);
            set.add(checkUnique(string, word, stringBuilder));
        }
        System.out.println("Unique Morse Words: " + set.size());
    }

    static String checkUnique(String[] string, String word, StringBuilder stringBuilder) {
        for (int i = 0; i < word.length(); i++)
            stringBuilder.append(string[word.charAt(i) - 'a']);
        return stringBuilder.toString();
    }
}
