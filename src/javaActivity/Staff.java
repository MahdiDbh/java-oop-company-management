package javaActivity;

import java.util.ArrayList;

// Manages all the company staff
// Responsibles are in a separate list to avoid counting their salary twice
public class Staff {

    private ArrayList<Employee>    employees;    // regular employees + salespeople
    private ArrayList<Responsible> responsibles; // managers

    // Constructor — creates two empty lists
    public Staff() {
        this.employees    = new ArrayList<>();
        this.responsibles = new ArrayList<>();
    }

    // Getters
    public ArrayList<Employee>    getEmployees()    { return employees; }
    public ArrayList<Responsible> getResponsibles() { return responsibles; }

    // Adds an employee to the right list based on their type (instanceof)
    // Prints a warning if the ID already exists
    public void addEmployee(Employee e) {
        if (e == null) return;

        if (e instanceof Responsible) {
            addResponsible((Responsible) e);
        } else {
            if (!employees.contains(e)) {
                employees.add(e);
            } else {
                System.out.println("[Warning] Employee with id="
                        + e.getId() + " already in the list.");
            }
        }
    }

    // Adds a responsible to the responsibles list
    public void addResponsible(Responsible r) {
        if (r == null) return;
        if (!responsibles.contains(r)) {
            responsibles.add(r);
        } else {
            System.out.println("[Warning] Responsible with id="
                    + r.getId() + " already in the list.");
        }
    }

    // Searches for an employee by ID in both lists, returns null if not found
    public Employee searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) return emp;
        }
        for (Responsible r : responsibles) {
            if (r.getId() == id) return r;
        }
        System.out.println("[Not found] No employee with id=" + id);
        return null;
    }

    // Prints all employees then all responsibles
    public void displayStaff() {
        System.out.println("\n========== EMPLOYEES ==========");
        if (employees.isEmpty()) {
            System.out.println("  (no regular employees)");
        } else {
            for (Employee emp : employees) {
                emp.displayEmpInfo();
            }
        }

        System.out.println("\n========== RESPONSIBLES ==========");
        if (responsibles.isEmpty()) {
            System.out.println("  (no responsibles)");
        } else {
            for (Responsible r : responsibles) {
                r.displayEmpInfo();
            }
        }
    }

    // Prints the hierarchy: each responsible with their subordinates
    public void displayHierarchy() {
        System.out.println("\n========== HIERARCHY ==========");
        if (responsibles.isEmpty()) {
            System.out.println("  No responsibles defined.");
            return;
        }
        for (Responsible r : responsibles) {
            System.out.println();
            r.printResponsibleDetails();
        }
    }

    // Calculates the total monthly payroll
    public double totalSalaries() {
        double total = 0.0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        for (Responsible r : responsibles) {
            total += r.calculateSalary();
        }
        return total;
    }
}
