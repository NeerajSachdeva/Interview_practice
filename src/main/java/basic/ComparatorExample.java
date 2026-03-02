package basic;
import java.util.*;

public class ComparatorExample {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1,"John",6000));
        list.add(new Employee(2,"Mike",2000));
        list.add(new Employee(3,"Adam",6000));
        list.add(new Employee(4,"Sara",1000));

        list.sort(
                Comparator.comparing((Employee e) -> e.getSalary(), Comparator.reverseOrder())
                        .thenComparing(e -> e.getName())
        );

        list.sort(
                Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
                        .thenComparing(Employee::getName)
        );

        System.out.println(list);
    }
}