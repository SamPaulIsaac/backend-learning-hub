public class CountWordWithPrefix {
    public static void main(String[] args) {
        String[] words = {"leetcode", "win", "loops", "success"};
        String pref = "code";
        int count = 0;
        for (String word : words) {
            if (word.length() >= pref.length()) {
                if (word.substring(0, pref.length()).contains(pref))
                    count++;
            }
        }
        System.out.println("COUNT: " + count);
    }
}
