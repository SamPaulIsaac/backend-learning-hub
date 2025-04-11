public class Max69Numbers {
    public static void main(String[] args) {
        int num = 9996;
        String numStr = Integer.toString(num);
        char[] charArray = numStr.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 9 + '0') {
                charArray[i] = 9 + '0';
                break;
            }
        }
        System.out.println("RESULT: " + Integer.parseInt(new String(charArray)));
    }
}
