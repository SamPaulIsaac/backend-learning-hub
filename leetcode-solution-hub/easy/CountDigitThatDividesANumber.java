public class CountDigitThatDividesANumber {
    public static void main(String[] args) {
        int num = 121;
        int counter = 0, digit = num;
        while (digit > 0) {
            if (num % (digit % 10) == 0)
                counter++;
            digit = digit / 10;
        }
        System.out.println("COUNTER: " + counter);
    }
}
