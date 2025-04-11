public class DivAndNonDivSumDifference {
    public static void main(String[] args) {
        int n = 10, m = 3;
        int divSum = 0;
        int notDivSum = 0;
        for (int i = n; i > 0; i--) {
            if (i % m == 0)
                divSum += i;
            else if (i % m != 0)
                notDivSum += i;
        }
        System.out.println(notDivSum - divSum);
    }
}
