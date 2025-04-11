public class ShuffleString {
    public static void main(String[] args) {
        String s = "abc";
        int[] indices = {0, 1, 2};
        System.out.println(restoreString(s, indices));

    }

    public static String restoreString(String s, int[] indices) {
        char[] charArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[indices[i]] = s.charAt(i);
        }
        return new String(charArray);
    }
}
