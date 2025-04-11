public class MaxCountOfPositiveAndNegative {
    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};
        int nc = 0, pc = 0;
        for (int n : nums) {
            if (n < 0)
                nc++;
            else if (n > 0) pc++;
        }
        int count = Math.max(nc, pc);
        System.out.println("COUNT: " + count);
    }
}
