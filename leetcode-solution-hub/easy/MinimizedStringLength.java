import java.util.HashSet;

public class MinimizedStringLength {
    public static void main(String[] args) {
        String s = "baadccab";
        System.out.println("Minimized String Length using first approach: " + s.chars().distinct().count());

        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) set.add(ch);
        System.out.println("Minimized String Length using second approach: " + set.size());
    }
}
