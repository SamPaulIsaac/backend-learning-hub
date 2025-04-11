import java.util.HashMap;
import java.util.Map;

public class LongestSubstringPalindrome {
    public static void main(String[] args) {
        String input = "cbbd";
        System.out.println("RES: " + longestPalindrome(input));

    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

//    public static void main(String[] args) {
//        String input = "mac";
//        String longestPalindromeSubstring = longestPalindrome(input);
//        System.out.println("Longest Palindrome Substring: " + longestPalindromeSubstring);
//    }


    private static String longestSubstringOccurrenceInPalindrome(String s) {
        String longestPalindrome = "";
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String current = s.substring(i, j);
                if (isPalindrome(current) && current.length() > maxLength) {
                    longestPalindrome = current;
                    maxLength = current.length();
                }
            }
        }

        return longestPalindrome;
    }

    private static boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString().compareTo(str) == 0;
    }

    private static void firstSubstringOccurrenceInPalindrome(String input) {
        if (input.length() == 0) {
            System.out.println("Empty String.");
        }

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int charIndex = 0; charIndex < input.toCharArray().length; charIndex++) {
            if (result.isEmpty()) {
                char current = input.charAt(charIndex);
                if (map.containsKey(current)) {
                    for (int exist = map.get(current); exist <= charIndex; exist++) {
                        result.append(input.charAt(exist));
                    }
                } else {
                    map.put(input.charAt(charIndex), charIndex);
                }
            }
        }
        System.out.println("Result: " + result);
    }
}
