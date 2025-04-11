public class TruncateSentence {
    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;
        String[] ss = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(ss[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }
}
