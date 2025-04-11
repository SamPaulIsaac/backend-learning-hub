import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 1; right <= s.toCharArray().length - 1; right++) {
            char currentChar = s.charAt(right);
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                left = charIndex.get(currentChar);
            }
            charIndex.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left);
            System.out.println(charIndex);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "malayalam";
        int length = lengthOfLongestSubstring(str);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}
