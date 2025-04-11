public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Is the no, power of two: " + solution(n));
    }

    public static boolean solution(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            else n /= 2;
        }
        return true;
    }
}
