package javaActivity;

/**
 * Base class representing a company employee.
 *
 * Each employee has a name, a unique ID, and an hourly rate.
 * All employees work 160 hours per month.
 * Two employees are considered equal if they share the same ID.
 *
 * Implements Comparable<Employee> so employees can be sorted by ID.
 */
public class Employee implements Comparable<Employee> {

    // I made these protected so subclasses can access them directly
    protected String name;
    protected int id;
    protected hourlyRate hr;

    // Same for everyone, so static final makes sense here
    public static final int numberOfWorkingHoursPerMonth = 160;

    /**
     * Constructor.
     *
     * @param name the employee's full name
     * @param id   unique employee ID
     * @param hr   the hourly rate category (LOW, MEDIUM, HIGH)
     */
    public Employee(String name, int id, hourlyRate hr) {
        this.name = name;
        this.id   = id;
        this.hr   = hr;
    }

    // --- Getters ---

    public String getName()    { return name; }
    public int getId()         { return id; }
    public hourlyRate getHr()  { return hr; }

    /**
     * Calculates the monthly salary.
     * Formula: hourlyRate * numberOfWorkingHoursPerMonth
     *
     * @return monthly gross salary in euros
     */
    public double calculateSalary() {
        return hr.hourlyRate() * numberOfWorkingHoursPerMonth;
    }

    /**
     * Prints the employee's main info to the console.
     * Subclasses override this to add their own details.
     */
    public void displayEmpInfo() {
        System.out.println("------------------------------");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Rate   : " + hr + " (" + hr.hourlyRate() + " EUR/h)");
        System.out.printf( "Salary : %.2f EUR%n", calculateSalary());
    }

    /**
     * Two employees are equal if and only if they have the same ID.
     */
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

    /**
     * Natural ordering by ID (ascending).
     */
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + name + "]";
    }
}
