public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (i < j && j >= 0) {
            char currentI = s.charAt(i);
            if (isVowel(currentI)) {
                char currentJ = s.charAt(j);
                if (isVowel(currentJ)) {
                    sb.setCharAt(j, currentI);
                    sb.setCharAt(i, currentJ);
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }
        System.out.println("SB: " + sb);
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
