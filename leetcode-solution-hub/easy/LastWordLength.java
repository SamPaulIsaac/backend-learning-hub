public class LastWordLength {
    public static void main(String[] args) {
        String s = "this is to test   ";
        int wordCount = 0, length = s.length() - 1;
        while (s.charAt(length) == ' ' && length >= 0)
            length--;
        while (length >= 0 && s.charAt(length) != ' ') {
            wordCount++;
            length--;
        }
        System.out.println(wordCount);
    }
}
