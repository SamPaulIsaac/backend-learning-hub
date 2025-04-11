import java.util.ArrayList;
import java.util.List;

public class WordsContainingCharacter {
    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        char x = 'e';
        System.out.println("Indices: " + Solution(words, x));
    }

    public static List<Integer> Solution(String[] words, char x) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1)
                output.add(i);
        }
        return output;
    }
}
