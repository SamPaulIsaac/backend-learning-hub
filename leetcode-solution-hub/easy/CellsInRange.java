import java.util.ArrayList;
import java.util.List;

public class CellsInRange {
    public static void main(String[] args) {
        String s = "A1:F2";
        List<String> resultList = new ArrayList<>();
        for (char column = s.charAt(0); column <= s.charAt(3); column++) {
            for (char row = s.charAt(1); row <= s.charAt(4); row++) {
                resultList.add(new String(new char[]{column, row}));
            }
        }
        System.out.println(resultList);


    }
}
