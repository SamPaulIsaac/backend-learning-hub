import java.util.HashMap;

public class IsomorphicString {

    public static boolean areIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else map1.put(c1, c2);
            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) return false;
            } else map2.put(c2, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";

        boolean result = areIsomorphic(s1, s2);
        System.out.println("Are the strings isomorphic? " + result);
    }
}

