public class TwoStringArrayEquivalent {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(Solution(word1, word2));
    }

    public static boolean Solution(String[] word1, String[] word2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (String str : word1)
            stringBuilder1.append(str);
        for (String str : word2)
            stringBuilder2.append(str);

        return stringBuilder1.compareTo(stringBuilder2) == 0;
    }
}
