public class MergeAlternative {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pqrs";
        StringBuilder stringBuilder = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i <= min - 1; i++) {
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(i));
        }
        if (word1.length() < word2.length())
            stringBuilder.append(word2.substring(min));
        else
            stringBuilder.append(word1.substring(min));
        System.out.println(stringBuilder);
    }
}
