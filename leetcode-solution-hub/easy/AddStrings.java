public class AddStrings {
    public static void main(String[] args) {
        String num1 = "1", num2 = "9";
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        int sum, remainder = 0;
        StringBuilder sb = new StringBuilder();
        while (length1 >= 0 || length2 >= 0) {
            int value1 = length1 >= 0 ? num1.charAt(length1) - '0' : 0;
            int value2 = length2 >= 0 ? num2.charAt(length2) - '0' : 0;
            sum = (value1 + value2 + remainder) % 10;
            remainder = (value1 + value2 + remainder) / 10;
            sb.append(sum);
            length1--;
            length2--;
        }
        if (remainder > 0) sb.append(remainder);
        System.out.println("OUTPUT: " + sb.reverse().toString());
    }
}
