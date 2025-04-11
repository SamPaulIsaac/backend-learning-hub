public class ScoreOfAString {
    public static void main(String[] args) {
        String s = "zaz";
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++)
            sum += Math.abs(s.charAt(i + 1) - s.charAt(i));

        System.out.println(sum);
    }
}
