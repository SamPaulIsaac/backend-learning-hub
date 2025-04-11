public class SquareRoot {
    public static void main(String[] args) {
        int x = 8;
        //First Approach
        long n = x;
        while (n * n > x) {
            n = (n + x / n) / 2;
        }
        System.out.println("Result: " + n);

        //Second Approach
        //System.out.println(mySqrt(x));
    }

    static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 0;
        int end = x;
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
