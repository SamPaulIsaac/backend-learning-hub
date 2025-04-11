public class PowerOfFour {
    public static void main(String[] args) {
        int n = 16;
        System.out.println("Is the no, power of four: " + solution(n));
    }

    public static boolean solution(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 4 != 0) return false;
            else n /= 4;
        }
        return true;
    }
}
