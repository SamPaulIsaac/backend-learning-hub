import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(sum);
            }
            if (i > 0) row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> pascalsTriangle = generatePascalsTriangle(numRows);

        // Print the triangle
        for (List<Integer> row : pascalsTriangle) {
            System.out.println(row);
        }
    }
}
