package basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondHighestEmployees2 {

  private int id;
  private String name;
  private double salary;

  public SecondHighestEmployees2(int id, String name, double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  public static void main(String[] args) {
    List<SecondHighestEmployees2> employees = new ArrayList<>();
    employees.add(new SecondHighestEmployees2(1, "John", 50000));
    employees.add(new SecondHighestEmployees2(2, "Alice", 60000));
    employees.add(new SecondHighestEmployees2(3, "Bob", 55000));
    employees.add(new SecondHighestEmployees2(4, "Carol", 60000));

    // Use Java streams and Lambdas to find the second highest salaried employees
    Map<Double, List<SecondHighestEmployees2>> salaryGroups = employees.stream().collect(Collectors.groupingBy(SecondHighestEmployees2::getSalary));

    List<Double> uniqueSalaries = salaryGroups.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    if (uniqueSalaries.size() > 1) {
      double secondHighestSalary = uniqueSalaries.get(1);
      List<SecondHighestEmployees2> secondHighestSalariedEmployees = salaryGroups.get(secondHighestSalary);

      System.out.println("Second highest salaried employee(s):");
      for (SecondHighestEmployees2 employee : secondHighestSalariedEmployees) {
        System.out.println(employee.getName());
      }
    } else {
      System.out.println("Not enough employees to find the second highest salary.");
    }
  }

  public double getSalary() {
    return salary;
  }
  public String getName() {
    return name;
  }
}


