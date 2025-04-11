public class NumbersAscendingInSentence {
    public static void main(String[] args) {
        // String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        String s = "hello world 5 x 5";
        System.out.println("Result: " + solution(s));
    }

    static boolean solution(String s) {
        int previousNumber = -1;
        String[] words = s.split(" ");
        for (String word : words) {
            if (!Character.isDigit(word.charAt(0))) continue;
            int currentNumber = Integer.parseInt(word);
            if (currentNumber <= previousNumber) return false;
            previousNumber = currentNumber;
        }
        return true;
    }
}
