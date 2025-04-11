public class KeyChange {
    public static void main(String[] args) {
        String s = "AaAaAaaAbBcC";
        System.out.println("Change: " + Solution(s));
    }

    public static Integer Solution(String s) {
        int change = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.toLowerCase().charAt(i) != s.toLowerCase().charAt(i + 1))
                change += 1;
        }
        return change;
    }
}
