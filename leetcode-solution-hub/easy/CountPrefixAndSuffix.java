public class CountPrefixAndSuffix {
    public static void main(String[] args) {
        String[] words = {"a", "ababa", "aba"};
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(current)
                        && words[j].endsWith(current)) {
                    count = count + 1;
                }
            }
        }
        System.out.println("Prefix and suffix count: " + count);
    }
}
