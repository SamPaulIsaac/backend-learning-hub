import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";

        System.out.println(isValid(s1)); // Output: true
        System.out.println(isValid(s2)); // Output: false
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topValue = stack.pop();
                if ((c == ')' && topValue != '(')
                        || (c == ']' && topValue != '[')
                        || (c == '}' && topValue != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

        //SECOND APPROACH
//        Stack<Character> stack = new Stack<>();
//        HashMap<Character, Character> bracketPairs = new HashMap<>();
//        bracketPairs.put(')', '(');
//        bracketPairs.put(']', '[');
//        bracketPairs.put('}', '{');
//
//        for (char c : s.toCharArray()) {
//            if (bracketPairs.containsValue(c)) {
//                stack.push(c);
//            } else if (bracketPairs.containsKey(c)) {
//                if (stack.isEmpty() || stack.pop() != bracketPairs.get(c)) {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        return stack.isEmpty();
    }
}
