import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println("Roman to integer using map approach: " + solutionUsingMap(s));
        System.out.println("Roman to integer using switch approach: " + solutionUsingSwitch(s));
    }

    private static int solutionUsingSwitch(String s) {
        int a = 0, b = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            a = switch (c1) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> a;
            };

            if (i + 1 < s.length()) {
                char c2 = s.charAt(i + 1);
                b = switch (c2) {
                    case 'I' -> 1;
                    case 'V' -> 5;
                    case 'X' -> 10;
                    case 'L' -> 50;
                    case 'C' -> 100;
                    case 'D' -> 500;
                    case 'M' -> 1000;
                    default -> b;
                };
            }
            if (a >= b) count += a;
            else count -= a;
        }
        return count;
    }


    private static int solutionUsingMap(String s) {

        Map<Character, Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);

        int romanConvertedInt = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanToIntegerMap.get(s.charAt(i));
            if (i < s.length() - 1 && currentValue < romanToIntegerMap.get(s.charAt(i + 1))) {
                romanConvertedInt -= currentValue;
                System.out.println("RC 1: " + romanConvertedInt);
            } else {
                romanConvertedInt += currentValue;
                System.out.println("RC 2: " + romanConvertedInt);
            }
        }
        return romanConvertedInt;
    }
}
