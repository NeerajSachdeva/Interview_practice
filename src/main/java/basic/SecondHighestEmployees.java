package basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondHighestEmployees {
  private int id;
  private String name;
  private double salary;

  public SecondHighestEmployees(int id, String name, double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  public double getSalary() {
    return salary;
  }

  public static void main(String[] args) {
    List<SecondHighestEmployees> employees = new ArrayList<>();
    employees.add(new SecondHighestEmployees(1, "John", 50000));
    employees.add(new SecondHighestEmployees(2, "Alice", 60000));
    employees.add(new SecondHighestEmployees(3, "Bob", 55000));
    employees.add(new SecondHighestEmployees(4, "Carol", 60000));

    // Use Java streams and Lambdas to find the second highest salaried employees
    List<SecondHighestEmployees> sortedEmployees =
        employees.stream().sorted(Comparator.comparingDouble(SecondHighestEmployees::getSalary).reversed()).collect(Collectors.toList());

    if (sortedEmployees.size() >= 2) {
      double secondHighestSalary = sortedEmployees.get(1).getSalary();
      List<SecondHighestEmployees> secondHighestSalariedEmployees =
          sortedEmployees.stream().filter(employee -> employee.getSalary() == secondHighestSalary).collect(Collectors.toList());

      // or better
      // List<SecondHighestEmployees> emp = new ArrayList<>();
      // for (SecondHighestEmployees e : sortedEmployees) {
      // if (e.getSalary() == secondHighestSalary) {
      // emp.add(e);
      // continue;
      // }
      // break;
      // }

      System.out.println("Second highest salaried employee(s):");
      for (SecondHighestEmployees employee : secondHighestSalariedEmployees) {
        System.out.println(employee.getName());
      }
    } else {
      System.out.println("Not enough employees to find the second highest salary.");
    }
  }

  public String getName() {
    return name;
  }
}


