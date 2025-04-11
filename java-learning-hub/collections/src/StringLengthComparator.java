import java.util.Arrays;
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    public static void main(String[] args) {
        String[] strings = {"apple", "orange", "banana", "grapes", "abc"};

        // Sort the strings array using the custom comparator
        Arrays.sort(strings, new StringLengthComparator());

        // Print the sorted array
        for (String str : strings) {
            System.out.println(str);
        }
    }

    @Override
    public int compare(String s1, String s2) {
        // Compare strings based on their lengths
        return Integer.compare(s1.length(), s2.length());
    }
}

