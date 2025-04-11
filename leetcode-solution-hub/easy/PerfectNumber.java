public class PerfectNumber {
    public static void main(String[] args) {
        int num = 28, sum = 0, i = 1;
        while (i < num) {
            if (num % i == 0) sum += i;
            i++;
        }
        System.out.println("SUM: " + sum);

        if (sum == num) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
