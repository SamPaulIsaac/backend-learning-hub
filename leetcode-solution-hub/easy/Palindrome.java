import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        if (isPalindromeFirstSolution(121) && isPalindromeUsingSecondApproach(121))
            System.out.println("Palindrome.");
        else
            System.out.println("Not a Palindrome.");
    }

    public static boolean isPalindromeFirstSolution(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;

        Stack<Character> stack = new Stack<>();
        String numberString = String.valueOf(x);

        for (int i = 0; i < numberString.toCharArray().length; i++) {
            stack.push(numberString.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (int i = stack.size(); i > 0; i--) {
            result.append(stack.pop());
        }
        return result.toString().equals(numberString);
    }


    public static boolean isPalindromeUsingSecondApproach(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;

        String value = String.valueOf(x);
        int left = 0;
        int right = value.length() - 1;

        while (left < right) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
