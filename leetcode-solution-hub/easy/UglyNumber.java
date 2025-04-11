public class UglyNumber {
    public static void main(String[] args) {
        int num = 6;
        if (num == 1) System.out.println("TRUE");
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (num % factor == 0) {
                num /= factor;
            }
        }
        System.out.println("NUM: " + (num == 1));
    }
}
