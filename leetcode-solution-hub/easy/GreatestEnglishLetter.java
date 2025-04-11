import java.util.HashSet;
import java.util.Set;

public class GreatestEnglishLetter {
    public static void main(String[] args) {
        String s = "aAbcDd";
        System.out.println("Greatest Letter using first approach: " + firstSolution(s));
        System.out.println("Greatest Letter using second approach: " + secondSolution(s));
    }

    static String firstSolution(String s) {
        char greatestLetter = ' ';
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);
        for (char z = 'Z'; z >= 'A'; z--) {
            if (set.contains(z) && set.contains(Character.toLowerCase(z))) if (z > greatestLetter) greatestLetter = z;
        }
        return greatestLetter == ' ' ? "" : String.valueOf(greatestLetter);
    }

    static String secondSolution(String s) {
        System.out.println("a: " + (int) 'a');
        System.out.println("b: " + (int) 'z');
        System.out.println("A: " + (int) 'A');
        System.out.println("Z: " + (int) 'Z');
        for (char z = 'Z'; z >= 'A'; z--) {
            if (s.contains(Character.toString(z)) && s.contains(Character.toString(Character.toLowerCase(z))))
                return Character.toString(z);
        }
        return "";
    }
}
