public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("Reverse of 120: " + reverse(120));
        System.out.println("Reverse of 123: " + reverse(123));
        System.out.println("Reverse of -123: " + reverse(-123));
    }

    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }
}
