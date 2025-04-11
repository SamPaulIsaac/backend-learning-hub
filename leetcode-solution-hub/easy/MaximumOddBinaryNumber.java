public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        String s = "010";
        char[] chars = s.toCharArray();
        System.out.println(s.lastIndexOf('1'));
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '1' && i == chars.length - 1) {
                chars[i] = '1';
            } else if (chars[i] == '1' && i != 0 && chars[i - 1] == '0') {
                chars[i] = '0';
                chars[i - 1] = '1';
            } else if (chars[i] == '0' && i == chars.length - 1) {
                int index = s.lastIndexOf('1');
                chars[i] = chars[index];
                chars[index] = '0';
            }
        }
        System.out.println(new String(chars));
    }
}
