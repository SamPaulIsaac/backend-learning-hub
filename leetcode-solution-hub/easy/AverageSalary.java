import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class AverageSalary {
    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        int minValue = Arrays.stream(salary).min().getAsInt();
        int maxValue = Arrays.stream(salary).max().getAsInt();
        System.out.println("Min: " + minValue);
        System.out.println("Max: " + maxValue);

        System.out.println(Arrays.stream(salary).filter(val -> val != minValue && val != maxValue).average().getAsDouble());

        List<Integer> filteredSalaries = Arrays.stream(salary)
                .boxed() // Convert IntStream to Stream<Integer>
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), list -> {
                            IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();
                            int min = stats.getMin();
                            int max = stats.getMax();
                            return list.stream()
                                    .filter(val -> val != min && val != max)
                                    .collect(Collectors.toList());
                        }));

        OptionalDouble average = filteredSalaries.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Filtered Salaries: " + filteredSalaries);
        System.out.println("Average Salary: " + average.getAsDouble());
    }
}
