public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 5;
    }

    public static boolean isBadVersion(int n) {
        return true; //Actual implementation is inbuild in leet code system.
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
