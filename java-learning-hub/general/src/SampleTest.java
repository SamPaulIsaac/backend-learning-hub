class StringSolution {
    public String solution(String input) {
        int currentCountValue = 0;
        int count = 0;
        StringBuilder combinedString = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                currentCountValue = c - '0';
            } else if (c == '[') {
                count = currentCountValue;
                ans = new StringBuilder(ans);
            } else if (c == ']') {
                for (int i = 1; i <= count; i++) {
                    ans.append(combinedString);
                }
                currentCountValue = 0;
                combinedString = new StringBuilder();
            } else {
                combinedString.append(c);
            }
        }
        return ans.toString();
    }
}

public class SampleTest {
    public static void main(String[] args) {
        StringSolution stringSolution = new StringSolution();
        System.out.println(stringSolution.solution("3[a]2[bc]")); // output should be aaabcbc
        System.out.println(stringSolution.solution("3[a2[b]]"));  // output should be abbabbabb
    }
}
