package javaActivity;

// Base class for all employees
// Each employee has a name, a unique ID, and an hourly rate
// Two employees are equal if they have the same ID
public class Employee implements Comparable<Employee> {

    // protected so subclasses can access them directly
    protected String name;
    protected int id;
    protected hourlyRate hr;

    // 160h per month for everyone
    public static final int numberOfWorkingHoursPerMonth = 160;

    // Constructor
    public Employee(String name, int id, hourlyRate hr) {
        this.name = name;
        this.id   = id;
        this.hr   = hr;
    }

    // Getters
    public String getName()    { return name; }
    public int getId()         { return id; }
    public hourlyRate getHr()  { return hr; }

    // Salary = hourly rate * 160h
    public double calculateSalary() {
        return hr.hourlyRate() * numberOfWorkingHoursPerMonth;
    }

    // Prints basic info (subclasses override this method)
    public void displayEmpInfo() {
        System.out.println("------------------------------");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Rate   : " + hr + " (" + hr.hourlyRate() + " EUR/h)");
        System.out.printf( "Salary : %.2f EUR%n", calculateSalary());
    }

    // Two employees are equal if they have the same ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    // Sort by ID ascending
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + name + "]";
    }
}
