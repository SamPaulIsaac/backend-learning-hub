public class GuessNoHigherOrLower {
    public static void main(String[] args) {
        System.out.println("Solution: "+guessNumber(10));
    }
    public static int guess(int n){
        return 0;
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid); //inbuilt method.
            if (result == 0)
                return mid;
            else if (result == -1)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
