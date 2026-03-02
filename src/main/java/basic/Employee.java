package basic;

import java.time.LocalDate;

public class Employee {
    long id;
    String name;
    LocalDate date;
    int salary;

    public Employee(long id, String name, LocalDate date) {
        this.id =id;
        this.name = name;
        this.date = date;
    }


    public Employee(long id, String name, int salary) {
        this.id =id;
        this.name = name;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", date=").append(date);
        sb.append(", salary=").append(salary);
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }
}
