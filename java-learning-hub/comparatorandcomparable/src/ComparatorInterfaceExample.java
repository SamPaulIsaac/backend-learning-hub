import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorInterfaceExample {
    public static void main(String[] args) {
        List<Footballer> footballers = new ArrayList<>(List.of(new Footballer("sam", 29), new Footballer("matt", 25), new Footballer("alice", 27), new Footballer("vernon", 28)));
        footballers.sort(new FootballerComparatorByName());
        System.out.println("class - Sorted by name: " + footballers);
        footballers.sort(new FootballerComparatorByAge());
        System.out.println("Class - Sorted by age: " + footballers);

        // Second approach
        Comparator<Footballer> footballerComparatorByAge = Comparator.comparing(Footballer::getAge);
        footballers.sort(footballerComparatorByAge);
        System.out.println("Lambda expression - Sorted by age: " + footballers);
        Comparator<Footballer> footballerComparatorByName = Comparator.comparing(Footballer::getName);
        footballers.sort(footballerComparatorByName);
        System.out.println("Lambda expression - Sorted by name: " + footballers);
    }
}


class Footballer {
    String name;
    int age;

    public Footballer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Cricketer{name=" + name + ", age='" + age + "'}";
    }
}

class FootballerComparatorByName implements Comparator<Footballer> {
    @Override
    public int compare(Footballer footballer1, Footballer footballer2) {
        return footballer1.getName().compareTo(footballer2.getName());
    }
}

class FootballerComparatorByAge implements Comparator<Footballer> {
    @Override
    public int compare(Footballer footballer1, Footballer footballer2) {
        return Integer.compare(footballer1.getAge(), footballer2.getAge());
    }
}