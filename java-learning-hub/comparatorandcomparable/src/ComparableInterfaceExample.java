import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableInterfaceExample {
    public static void main(String[] args) {
        List<Cricketer> cricketerList = new ArrayList<>(List.of(new Cricketer("sam", 29), new Cricketer("matt", 25), new Cricketer("alice", 27), new Cricketer("vernon", 28)));
        Collections.sort(cricketerList);
        System.out.println("Total comparisons: " + Cricketer.getComparisonCount());
    }
}


class Cricketer implements Comparable<Cricketer> {
    private static int comparisonCount = 0;
    String name;
    int age;

    public Cricketer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int getComparisonCount() {
        return comparisonCount;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Cricketer cricketer) {
        System.out.println("Comparison between: " + this.name + " and " + cricketer.getName());
        comparisonCount++;
        return Integer.compare(this.getAge(), cricketer.age);
        //return this.getName().compareTo(cricketer.getName());
    }

    @Override
    public String toString() {
        return "Cricketer{name=" + name + ", age='" + age + "'}";
    }
}