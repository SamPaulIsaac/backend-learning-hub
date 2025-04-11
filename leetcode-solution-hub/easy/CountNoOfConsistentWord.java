public class CountNoOfConsistentWord {
    public static void main(String[] args) {
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        String allowed = "cad";

        boolean[] isAllowed = new boolean[26];
        for (char c : allowed.toCharArray()) isAllowed[c - 'a'] = true;
        int consistentWords = 0;
        for (String word : words) {
            if (validateConsistency(word, isAllowed)) consistentWords++;
        }
        System.out.println("Total no of consistent words: " + consistentWords);
    }

    private static boolean validateConsistency(String word, boolean[] isAllowed) {
        for (char c : word.toCharArray()) if (!isAllowed[c - 'a']) return false;
        return true;
    }
}
