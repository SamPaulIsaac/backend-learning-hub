public class CanConstruct {
    public static void main(String[] args) {
        System.out.println("Result: " + canConstruct("aab", "baa"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        for (char c : magazine.toCharArray()) charCount[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) return false;
            charCount[c - 'a']--;
        }

        return true;
    }


}
