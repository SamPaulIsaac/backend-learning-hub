public class MakeThreeStringsEqual {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abb";
        String s3 = "ab";
        System.out.println("No of operations required to make three strings equal: " + solution(s1, s2, s3));
    }

    public static int solution(String s1, String s2, String s3) {
        int string1Length = s1.length();
        int string2Length = s2.length();
        int string3Length = s3.length();

        int i;
        int minLength = Math.min(string1Length, Math.min(string2Length, string3Length));

        for (i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i) || s2.charAt(i) != s3.charAt(i)) {
                break;
            }
        }
        return (i == 0) ? -1 : (string1Length + string2Length + string3Length) - (3 * i);
    }
}
