public class ClearDigits {
    public static void main(String[] args) {
        String s = "abc";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
            } else sb.append(c);
        }
        System.out.println("Final Result: " + sb);
    }


}
