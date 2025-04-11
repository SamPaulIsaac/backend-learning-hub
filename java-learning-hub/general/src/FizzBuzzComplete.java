import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzzComplete {
    public static void main(String[] args) {
        int n = 15;
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("FizzBuzz solution for the input: %d%n", n);
        solveFizzBuzz(n);
        System.out.println("-------------------------------------------------------------------------------");

        String[] fizzBuzzOutput = {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"};
        System.out.printf("FizzBuzz reverse for the input: %s%n", Arrays.toString(fizzBuzzOutput));
        solveReverseFizzBuzz(fizzBuzzOutput);
        System.out.println("-------------------------------------------------------------------------------");
    }

    // Solves reverse FizzBuzz to find original f and b
    private static void solveReverseFizzBuzz(String[] fizzBuzzOutput) {
        List<Integer> fizzPositions = new ArrayList<>();
        List<Integer> buzzPositions = new ArrayList<>();

        // Identify Fizz and Buzz positions
        for (int i = 0; i < fizzBuzzOutput.length; i++) {
            if (fizzBuzzOutput[i].contains("Fizz")) fizzPositions.add(i + 1);
            if (fizzBuzzOutput[i].contains("Buzz")) buzzPositions.add(i + 1);
        }

        System.out.printf("Fizz Positions: %s and Buzz Positions: %s%n", fizzPositions, buzzPositions);

        // Find the minimum gap between consecutive Fizz and Buzz positions
        int fmin = findMinDifference(fizzPositions);
        int bmin = findMinDifference(buzzPositions);

        System.out.println(String.format("Fizz Min (f): %d and Buzz Min (b): %d", fmin, bmin));
    }

    // Finds the minimum difference between consecutive elements in the list
    private static int findMinDifference(List<Integer> positions) {
        if (positions.size() < 2) return -1; // Not enough positions to calculate a difference

        int minDiff = positions.get(1) - positions.get(0);
        for (int i = 1; i < positions.size() - 1; i++) {
            int diff = positions.get(i + 1) - positions.get(i);
            if (diff < minDiff) minDiff = diff;
        }
        return minDiff;
    }

    // Solves the FizzBuzz problem for the given input n
    private static void solveFizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        System.out.println(result);
    }
}
