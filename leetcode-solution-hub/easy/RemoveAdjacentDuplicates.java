import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.contains(c)) {
                if (stack.peek().equals(c)) stack.removeElement(c);
                else stack.push(c);
            } else stack.push(c);
        }

        System.out.println("RESULT: " + stack.stream().map(Object::toString).collect(Collectors.joining()));
    }
}
