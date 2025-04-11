import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatchingArray {
    public static void main(String[] args) {
        String[] words = {"leetcoder", "leetcode", "od", "hamlet", "am"};
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        System.out.println("Result; " + result);
    }
}
