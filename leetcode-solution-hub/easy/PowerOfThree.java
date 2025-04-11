public class PowerOfThree {
    public static void main(String[] args) {
        int n = 27;
        System.out.println("Is the no, power of three: " + solution(n));
    }

    public static boolean solution(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            else n /= 3;
        }
        return true;
    }
}
