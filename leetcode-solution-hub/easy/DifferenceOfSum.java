public class DifferenceOfSum {
    public static void main(String[] args) {
        int[] nums = {1, 15, 6, 3};
        int elementSum = 0;
        int digitSum = 0;
        for (int i : nums) {
            elementSum += i;
            int j = i;
            while (j > 0) {
                int rem = j % 10;
                digitSum += rem;
                j /= 10;
            }
        }
        System.out.println(elementSum);
        System.out.println(digitSum);
    }
}
