public class DistinctIntegers {
    public static int count = 1;

    public static void main(String[] args) {
        int n = 5;
        System.out.println("RESULT: " + distinctIntegers(n));
    }


    static int distinctIntegers(int n) {
        if (n == 1) return count;
        int i = n - 1;
        while (i >= 1) {
            if (n % i == 1) {
                count++;
                return distinctIntegers(i);
            }
            i--;
        }
        return count;
    }

}
