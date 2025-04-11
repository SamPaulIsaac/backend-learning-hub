public class ValidPerfectNumber {
    public static void main(String[] args) {
        int num = 808201;
        System.out.println("Is valid perfect number: " + solution(num));
    }

    public static boolean solution(int num) {
        if (num < 0) return false;
        if (num < 2) return true;
        int start = 1, end = num/2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long calc = (long) mid * mid;
            if (calc == num) return true;
            else if (calc < num) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
