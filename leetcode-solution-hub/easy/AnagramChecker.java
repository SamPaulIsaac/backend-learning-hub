import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    public static void main(String[] args) {
        String firstWord = "listen";
        String secondWord = "silent";
        boolean resultOfFirstApproach = isAnagramFirstApproach(firstWord, secondWord);
        boolean resultOfSecondApproach = isAnagramSecondApproach(firstWord, secondWord);
        if (resultOfFirstApproach && resultOfSecondApproach)
            System.out.println("Given words are Anagram!");
        else
            System.out.println("Given words are not Anagram!");
    }

    //First Approach
    private static boolean isAnagramFirstApproach(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (Character c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (Character c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }


    // Second Approach
    private static boolean isAnagramSecondApproach(String firstWord, String secondWord) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        // Push characters from str1 onto stack
        for (char ch : firstWord.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : secondWord.toCharArray()) {
            if (map1.get(ch) != null) {
                map1.put(ch, map1.getOrDefault(ch, 0) - 1);
            } else {
                return false;
            }
        }
        return map1.values().stream().noneMatch(a -> a.toString().contains("1"));
    }
}
