import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ToStringExploration {
    public static void main(String[] args) {
        SportsPerson obj1 = new SportsPerson("SAM", "Male", 29, "India");
        SportsPerson obj2 = new SportsPerson("ADAM", "Male", 25, "England");
        SportsPerson obj3 = new SportsPerson("ABRAHAM", "Male", 27, "England");
        System.out.println("Response of toString(): " + obj1);
        System.out.println("Response of hashCode(): " + obj1.hashCode());
        System.out.println("Response of hashCode(): " + obj2.hashCode());
        System.out.println("Are obj1 and obj2 equal? " + obj1.equals(obj2));
        List<SportsPerson> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        System.out.println("\nDefault sorting...");
        list.stream().sorted();
        list.forEach(System.out::println);
        System.out.println("\nBefore sorting by age...");
        list.forEach(System.out::println);
        list.sort(SportsPerson.getByAge());
        System.out.println("\nAfter Sorting by age...");
        list.forEach(System.out::println);
        System.out.println("\nAfter Sorting by name...");
        list.sort(SportsPerson.getByName());
        list.forEach(System.out::println);

    }
}

class SportsPerson {
    String name;
    String gender;
    int age;
    String country;

    public SportsPerson(String name, String gender, int age, String country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public String toString() {
        return "SportsPerson[Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Country: " + country + "]";
    }

    public int hashCode() {
        return Objects.hash(name, age, gender, country);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (null == obj || obj.getClass() != this.getClass()) return false;

        SportsPerson sportsPerson = (SportsPerson) obj;
        return sportsPerson.name.equals(this.name) && sportsPerson.age == this.age && sportsPerson.country.equals(this.country) && sportsPerson.gender.equals(this.gender);
    }

    public static Comparator<SportsPerson> getByAge() {
        return Comparator.comparingInt(o -> o.age);
    }

    public static Comparator<SportsPerson> getByName() {
        return Comparator.comparing(o -> o.name);
    }

}