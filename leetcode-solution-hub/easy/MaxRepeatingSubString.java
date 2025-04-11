public class MaxRepeatingSubString {
    public static void main(String[] args) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
        System.out.println("The count of max repeating sub string using in built string method approach: " + solution1(sequence, word));
        System.out.println("The count of max repeating sub string using other approach: " + solution2(sequence, word));
    }

    public static int solution1(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }

    public static int solution2(String sequence, String word) {
        int maxCount = 0;
        int sequenceLength = sequence.length();
        int wordLength = word.length();

        for (int i = 0; i <= sequenceLength - wordLength; i++) {
            int currentCount = 0;
            int j = i;

            while (j <= sequenceLength - wordLength && sequence.substring(j, j + wordLength).equals(word)) {
                currentCount++;
                j += wordLength;
            }

            if (currentCount > maxCount) maxCount = currentCount;
        }

        return maxCount;
    }
}

