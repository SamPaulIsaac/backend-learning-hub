import java.util.HashSet;
import java.util.Set;

public class FirstLetterAppearTwice {
    public static void main(String[] args) {
        String s = "abccd";
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c))
                System.out.println("Repeated Character: " + c);
        }
    }
}
