public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println("Result: " + solution(s));
    }

    public static int solution(String s) {
        int[] array = new int[26];

        char[] chars = s.toCharArray();

        for (char c : chars) array[c - 'a']++;

        for (int i = 0; i < chars.length; i++)
            if (array[chars[i] - 'a'] == 1) return i;

        return -1;
    }
}
