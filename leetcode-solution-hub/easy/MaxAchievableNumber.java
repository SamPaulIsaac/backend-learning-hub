public class MaxAchievableNumber {
    public static void main(String[] args) {
        /*
            Logic:
            int num =4, t=1;
            t - no of operation //add 1 or delete 1
            int value1 = num+t;
            x-t = value1; // x-> value to find.
            x = value1 + t;
            int result = (t+(num+t))
         */
        int num = 4, t = 1;
        System.out.println("MAX: " + (t + (num + t)));
    }
}
