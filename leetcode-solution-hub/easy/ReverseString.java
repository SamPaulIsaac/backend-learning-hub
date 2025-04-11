import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        /*
            First Approach: This will return the result in a new char array.

            char[] result = new char[s.length];
            int value = 0;
            for (int i = s.length - 1; i >= 0; i--) {
            result[value] = s[i];
            value++;
            }
            System.out.println("RESULT: "+ Arrays.toString(result));
         */

        /*
            Second Approach: Perform the operation and return the result on the input array.
         */
        reverseCharArray(s);
        System.out.println("Reversed Array: " + Arrays.toString(s));
    }

    public static void reverseCharArray(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
