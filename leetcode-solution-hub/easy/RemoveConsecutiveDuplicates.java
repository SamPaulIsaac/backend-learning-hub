import java.util.Stack;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {

        String input = "abbccddeeffghiiaabb";
        StringBuilder resultOfFirstApproach = usingStringFunctions(input);
        StringBuilder resultOfSecondApproach = usingStack(input);
        if (resultOfSecondApproach.compareTo(resultOfFirstApproach) == 0)
            System.out.println("Result: " + resultOfFirstApproach);
        else
            System.out.println("There is some issue with the first/second approach.");
    }

    // First Approach
    public static StringBuilder usingStringFunctions(String input) {
        StringBuilder result = new StringBuilder();
        char previousChar = input.charAt(0);
        result.append(previousChar);
        for (
                char currentChar : input.toCharArray()) {
            if (currentChar != previousChar) {
                result.append(currentChar);
                previousChar = currentChar;
            }
        }
        return result;
    }

    // Second Approach
    public static StringBuilder usingStack(String input) {
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (!stack.empty() && stack.peek() == input.charAt(i)) {
            } else {
                stack.push(input.charAt(i));
                result.append(input.charAt(i));
            }
        }
        return result;
    }
}
