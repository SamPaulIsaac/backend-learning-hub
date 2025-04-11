public class NoOfStepsToReduceToZero {
    public static void main(String[] args) {
        int steps = 0;
        int num = 14;
        while (num > 0) {
            if (num % 2 == 0) num /= 2;
            else num -= 1;
            steps++;
        }
        System.out.println("STEPS: " + steps);
    }
}
