public class PunishmentNumber {
    public static void main(String[] args) {
        int number = 1000;

        for (int i = 1; i <= number; i++) {
            if (isPunishmentNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPunishmentNumber(int number) {
        int originalNumber = number;
        int numDigits = String.valueOf(number).length();
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits);
            number /= 10;
        }

        return sum == originalNumber;
    }
}

