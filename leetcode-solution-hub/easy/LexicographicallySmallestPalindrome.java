public class LexicographicallySmallestPalindrome {
    public static void main(String[] args) {
        String s = "egcfe";
        char[] c = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (c[left] != c[right]) {
//                if (c[left] < c[right]) c[right] = c[left];
//                else c[left] = c[right];
                c[left] = (char) Math.min(c[left], c[right]);
                c[right] = c[left];
            }
            left++;
            right--;
        }

        System.out.println(new String(c));
    }

}

