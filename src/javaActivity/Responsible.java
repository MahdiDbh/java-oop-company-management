package javaActivity;

import java.util.ArrayList;

// A manager: employee with a job title and a list of subordinates
public class Responsible extends Employee {

    private String title;

    private ArrayList<Employee> subordinates; // direct subordinates

    // Constructor
    public Responsible(String name, int id, hourlyRate hr, String title) {
        super(name, id, hr);
        this.title        = title;
        this.subordinates = new ArrayList<>();
    }

    // Getters
    public String getTitle() { return title; }

    public ArrayList<Employee> getSubordinates() { return subordinates; }

    // Adds a subordinate (ignores null and duplicates)
    public void addSubordinate(Employee e) {
        if (e != null && !subordinates.contains(e)) {
            subordinates.add(e);
        }
    }

    // Prints the list of subordinates
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

    // Prints full manager info + their subordinates
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

    @Override
    public void displayEmpInfo() {
        printResponsibleDetails();
    }

    @Override
    public String toString() {
        return "Responsible[id=" + id + ", name=" + name + ", title=" + title + "]";
    }
}
