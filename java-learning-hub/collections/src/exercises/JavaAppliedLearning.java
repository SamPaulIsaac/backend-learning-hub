package exercises;

import java.util.*;

public class JavaAppliedLearning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                 1.Remove Consecutive Duplicates
                 2.Return  Non Duplicates
                 3.Balanced Parentheses
                 4.PostFix Evaluator
                 5.Next Greater Element\
                """);
        int info = scanner.nextInt();
        if (info == 1) {

            /* Program 1: Remove Consecutive Duplicates.
                Eg:
                Input: aabccddeffggaabbb
                Output: abcdefgab
             */
            System.out.print("Enter the string on which consecutive duplicates has to be removed: ");
            String input = scanner.next();
            RemoveConsecutiveDuplicates obj = new RemoveConsecutiveDuplicates(input);
            obj.firstApproach();
            System.out.println("String after removing the consecutive duplicates using first approach: " + obj.getOutput());
            obj.secondApproach();
            System.out.println("String after removing the consecutive duplicates using second approach: " + obj.getOutput());
            obj.thirdApproach();
            System.out.println("String after removing the consecutive duplicates using third approach: " + obj.getOutput());

        } else if (info == 2) {

            /*
            Program 2: Return the String containing the chars which are not duplicated.
            Eg:
            Input: aabccddeffggaabbb
            Output: be
            */

            System.out.print("Enter the string to return the non duplicates: ");
            String duplicatedCharsInString = scanner.next();
            ReturnNonDuplicates returnNonDuplicates = new ReturnNonDuplicates(duplicatedCharsInString);
            returnNonDuplicates.performAction();
            System.out.println("Resultant String : " + returnNonDuplicates.getOutput());
        } else if (info == 3) {
            scanner.nextLine();
            System.out.println("Enter the string to check whether it has balanced parentheses: ");
            String string = scanner.findInLine(".*").replace(" ", "");
            BalancedParentheses balancedParentheses = new BalancedParentheses(string);
            balancedParentheses.performAction();
            System.out.println("Resultant String : " + balancedParentheses.getOutput());
        } else if (info == 4) {

            scanner.nextLine();
            System.out.println("Enter the expression: ");
            String string = scanner.next();
            PostfixEvaluator postfixEvaluator = new PostfixEvaluator(string);
            postfixEvaluator.performAction();
            System.out.println("Resultant String : " + postfixEvaluator.getResult());
        } else if (info == 5) {

            scanner.nextLine();
            System.out.print("Enter the length of the array: ");
            int length = scanner.nextInt();
            // Step 2: Create an array of the specified length
            int[] nums = new int[length];
            // Step 3: Read each integer from the user and store it in the array
            System.out.println("Enter the elements of the array, separated by spaces:");
            for (int i = 0; i < length; i++) {
                nums[i] = scanner.nextInt();
            }
            NextGreater nextGreater = new NextGreater(nums);
            nextGreater.performAction();
            System.out.println("Resultant String : " + Arrays.toString(nextGreater.getOutput()));
            nextGreater.performActionUsingSet();
        } else {
            System.out.println("Please specify the values in [1,2].");
        }

        scanner.close();
    }
}

class RemoveConsecutiveDuplicates {

    private String input;
    private StringBuilder output;

    RemoveConsecutiveDuplicates(String input) {
        setInput(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void setOutput(StringBuilder output) {
        this.output = output;
    }


    public void firstApproach() {

        String input = getInput();
        char[] converted = input.toCharArray();
        StringBuilder expected = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            expected.append(converted[i]);
            int j = i + 1;

            while (j < input.length() && converted[i] == converted[j]) {
                j++;
            }

            i = j;
        }
        setOutput(expected);
    }

    public void secondApproach() {
        String input = getInput();
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.toCharArray()[i];
            expected.append(currentChar);
            while (i + 1 < input.length() && currentChar == input.charAt(i + 1)) {
                i += 1;
            }
        }
        setOutput(expected);
    }

    public void thirdApproach() {
        String input = getInput();
        StringBuilder expected = new StringBuilder();
        String string = input.replaceAll("(.)\\1+", "$1");
        //System.out.println("RESULT : " + result);
        setOutput(expected.append(string));
    }
}

class ReturnNonDuplicates {

    private String input;
    private StringBuilder output;

    ReturnNonDuplicates(String input) {
        setInput(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void setOutput(StringBuilder output) {
        this.output = output;
    }

    public void performAction() {
        String input = getInput();
        StringBuilder expected = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : input.toCharArray()) {
            if (map.get(c) == 1) expected.append(c);
        }
        setOutput(expected);
    }
}

class BalancedParentheses {
    private String input;
    private Boolean output;

    BalancedParentheses(String input) {
        setInput(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Boolean getOutput() {
        return output;
    }

    public void setOutput(Boolean output) {
        this.output = output;
    }

    public void performAction() {
        String input = getInput();
        String updated = input.replace(" ", "");

        Stack<Character> stack = new Stack<>();

        for (char c : updated.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    setOutput(false);
                    break;
                }
            }
        }
        setOutput(stack.empty());
    }
}

class PostfixEvaluator {

    private String input;
    private Integer result;

    PostfixEvaluator(String input) {
        this.setInput(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    void performAction() {
        String input = getInput();

        Stack<Integer> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else if (checkOperator(c)) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                if (c == '+') {
                    stack.push(value1 + value2);
                } else if (c == '-') {
                    stack.push(value1 - value2);
                } else if (c == '*') {
                    stack.push(value1 * value2);
                } else if (c == '/') {
                    stack.push(value1 / value2);
                }
            }
        }
        setResult(stack.pop());
    }

    public Boolean checkOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

}

class NextGreater {

    private int[] input;
    private int[] output;

    NextGreater(int[] input) {
        setInput(input);
    }

    public int[] getInput() {
        return input;
    }

    public void setInput(int[] input) {
        this.input = input;
    }

    public int[] getOutput() {
        return output;
    }

    public void setOutput(int[] output) {
        this.output = output;
    }

    void performAction() {
        int[] input = getInput();
        int[] result = new int[input.length];
        int v = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j <= input.length; j++) {
                if (j == input.length) {
                    result[v] = -1;
                    v++;
                    break;
                } else if (input[j] > input[i]) {
                    result[v] = input[j];
                    v++;
                    break;
                }
            }
        }
        setOutput(result);
    }

    void performActionUsingSet() {
        int[] input = getInput();
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[i] > input[stack.peek()]) {
                map.put(stack.pop(), input[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < input.length; i++) {
            result[i] = map.getOrDefault(i, -1);
        }
        System.out.println("Result: " + Arrays.toString(result));
    }
}
