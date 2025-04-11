public class ReplaceDigitWithCharacters {
    public static void main(String[] args) {
        String s = "a1b2c3d4e";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                char prev = s.charAt(i - 1);
                sb.append((char) (prev + (current - '0')));
            } else sb.append(current);
        }
        System.out.println(sb);
    }
}
