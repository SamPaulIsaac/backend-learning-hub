public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println("Result using the first approach: " + solution1(s, goal));
        System.out.println("Result using the second approach: " + solution2(s, goal));
    }

    public static boolean solution1(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String check = s + s;
        return check.contains(goal);
    }

    public static boolean solution2(String s, String goal) {
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) return true;
        }
        return false;
    }
}
