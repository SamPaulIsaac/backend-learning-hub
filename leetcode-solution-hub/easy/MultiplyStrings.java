import java.util.Arrays;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "123456789", num2 = "987654321";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        // Handle edge case where one of the numbers is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // Reverse the strings for easier calculation
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        // Create an array to store the multiplication results
        int[] result = new int[n1.length() + n2.length()];

        // Perform multiplication
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                result[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        System.out.println(Arrays.toString(result));
        // Handle carry-over values
        for (int i = 0; i < result.length; i++) {
            if (result[i] >= 10) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        // Convert the result array back to a string
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && leadingZero) {
                continue;
            }
            leadingZero = false;
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
