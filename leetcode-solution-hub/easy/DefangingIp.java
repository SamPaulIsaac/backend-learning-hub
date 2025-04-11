public class DefangingIp {
    public static void main(String[] args) {
        String input = "1.1.1.1";
        System.out.println(input.replaceAll("[.]", "[.]"));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '.') {
                stringBuilder.append('[');
                stringBuilder.append('.');
                stringBuilder.append(']');
            } else {
                stringBuilder.append(current);
            }
        }
        System.out.println("SB: " + stringBuilder);
    }
}
