import java.util.Stack;

public class ReformatString {
    public static void main(String[] args) {
        String s = "ab123";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        Stack<Character> characterStack = new Stack<>();
        Stack<Character> integerStack = new Stack<>();
        for (char i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) integerStack.push(current);
            else characterStack.push(current);
        }

        int difference = Math.abs(characterStack.size() - integerStack.size());
        if (!(difference == 1 || difference == 0)) return "";

        if (characterStack.size() >= integerStack.size()) {
            while (!integerStack.isEmpty()) sb.append(characterStack.pop()).append(integerStack.pop());
            if (characterStack.size() > integerStack.size()) sb.append(characterStack.pop());
        } else if (integerStack.size() >= characterStack.size()) {
            while (!characterStack.isEmpty()) sb.append(integerStack.pop()).append(characterStack.pop());
            if (integerStack.size() > characterStack.size()) sb.append(integerStack.pop());
        }
        return sb.toString();
    }
}
