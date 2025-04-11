public class NoOfStringsAsSubStrings {
    public static void main(String[] args) {
        String[] patterns = {"a", "a", "a", "d"};
        String word = "ab";

        // 1. Better Performance - 0ms.
        int occurrenceCount = 0;
        for (String str : patterns) {
            if (word.contains(str))
                occurrenceCount++;
        }
        // 2. Performance - 2ms
        // occurrenceCount = (int) Arrays.stream(patterns).filter(word::contains).count();

        System.out.println(occurrenceCount);
    }
}
