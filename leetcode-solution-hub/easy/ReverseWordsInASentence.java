import java.util.Stack;

public class ReverseWordsInASentence {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop());
        }
        System.out.println("Result: " + result);
    }
}
