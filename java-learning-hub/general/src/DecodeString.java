import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        String input1 = "3[a]2[bc]";
        String input2 = "3[a2[c]]";
        System.out.println(decodeString(input1)); // Output: aaabcbc
        System.out.println(decodeString(input2)); // Output: accaccacc
    }
}

