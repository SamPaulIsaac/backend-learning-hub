public class RepeatedStringMatch {
    public static void main(String[] args) {
        String a = "abcd", b = "abcdb";
        System.out.println("No of repeats required : " + solution(a, b));
    }

    public static int solution(String a, String b) {
        StringBuilder repeated = new StringBuilder();
        int count = 0;
        while (repeated.length() < (b.length() + a.length())) {
            repeated.append(a);
            count++;
            if (repeated.indexOf(b) != -1) {
                return count;
            }
        }
        return -1;
    }
}
