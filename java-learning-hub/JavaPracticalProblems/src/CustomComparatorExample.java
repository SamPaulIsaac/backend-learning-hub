import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparatorExample {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John",5000d);
        Employee employee2 = new Employee("zoe",3000d);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add( employee2);

     Comparator<Employee> comparator1 =   Comparator
             .comparingDouble(Employee::getSalary);

        Comparator<Employee> comparator2 =   Comparator
                .comparing(Employee::getName)
                .thenComparingDouble(Employee::getSalary);

        Collections.sort(employeeList, comparator1);
        for(Employee e:employeeList)
            System.out.println(e.getName() + "                "+e.getSalary());

        Collections.sort(employeeList, comparator2);
        for(Employee e:employeeList)
            System.out.println(e.getName() + "                "+e.getSalary());

       List<Integer> l1 = List.of(1, 2, 3, 4, 5);
       List<String> l2 = List.of("apple", "banana", "kiwi");
        System.out.println(l1.stream().filter(a->a%2!=0)
               .mapToInt(b->b*b).sum());
        System.out.println(l2.stream().max(Comparator.comparingInt(String::length)));
    }
}

class Employee{
    String name;
    Double salary;

    public Employee(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }





}
