package javaActivity;

import java.util.ArrayList;

/**
 * Represents an employee with managerial responsibilities.
 *
 * A Responsible has a job title (e.g. "Team Leader") and a list
 * of direct subordinates. Subordinates are stored as Employee objects
 * so they can be any type (regular, salesperson, or even another responsible).
 *
 * Extends Employee.
 */
public class Responsible extends Employee {

    private String title;

    // Direct subordinates managed by this responsible
    private ArrayList<Employee> subordinates;

    /**
     * Constructor.
     *
     * @param name  the manager's name
     * @param id    unique employee ID
     * @param hr    hourly rate category
     * @param title the job title / role of this responsible
     */
    public Responsible(String name, int id, hourlyRate hr, String title) {
        super(name, id, hr);
        this.title        = title;
        this.subordinates = new ArrayList<>();
    }

    // --- Getters ---

    public String getTitle() { return title; }

    public ArrayList<Employee> getSubordinates() { return subordinates; }

    /**
     * Adds a direct subordinate. Ignores null and duplicate entries.
     *
     * @param e the employee to add as a subordinate
     */
    public void addSubordinate(Employee e) {
        if (e != null && !subordinates.contains(e)) {
            subordinates.add(e);
        }
    }

    /**
     * Prints all direct subordinates to the console.
     */
    public void printSubordinates() {
        System.out.println("  Subordinates of " + name + " (" + title + "):");
        if (subordinates.isEmpty()) {
            System.out.println("    (none)");
        } else {
            for (Employee emp : subordinates) {
                System.out.println("    -> [" + emp.getId() + "] " + emp.getName());
            }
        }
    }

    /**
     * Prints the responsible's full details:
     * personal info + title + list of subordinates.
     */
    public void printResponsibleDetails() {
        System.out.println("==============================");
        System.out.println("RESPONSIBLE");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Title  : " + title);
        System.out.println("Rate   : " + hr + " (" + hr.hourlyRate() + " EUR/h)");
        System.out.printf( "Salary : %.2f EUR%n", calculateSalary());
        printSubordinates();
    }

    /**
     * Override displayEmpInfo() to show full responsible details.
     */
    @Override
    public void displayEmpInfo() {
        printResponsibleDetails();
    }

    @Override
    public String toString() {
        return "Responsible[id=" + id + ", name=" + name + ", title=" + title + "]";
    }
}
