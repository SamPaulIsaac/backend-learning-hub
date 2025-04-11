import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println("Are the strings anagrams? " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] count = new int[256];
        for (char ch : s.toCharArray())
            count[ch]++;
        for (char ch : t.toCharArray())
            count[ch]--;

        return Arrays.stream(count).allMatch(val -> val == 0);
    }
}
