package javaActivity;

import java.util.ArrayList;

/**
 * Represents all the staff of the company.
 *
 * Manages two separate lists:
 *   - employees    : regular employees and salespeople
 *   - responsibles : managers with subordinates
 *
 * Note: I chose to keep Responsible objects out of the employees list
 * to avoid counting their salaries twice in totalSalaries().
 * The addEmployee() method automatically routes each object to the
 * correct list using instanceof.
 */
public class Staff {

    private ArrayList<Employee>    employees;
    private ArrayList<Responsible> responsibles;

    /**
     * Default constructor — initializes both empty lists.
     */
    public Staff() {
        this.employees    = new ArrayList<>();
        this.responsibles = new ArrayList<>();
    }

    // --- Getters ---

    public ArrayList<Employee>    getEmployees()    { return employees; }
    public ArrayList<Responsible> getResponsibles() { return responsibles; }

    /**
     * Adds an employee to the appropriate list based on their actual type.
     * - If Responsible  -> goes into the responsibles list
     * - Otherwise       -> goes into the employees list
     * Duplicates (same ID) are silently ignored with a warning.
     *
     * @param e the Employee to add (can be any subtype)
     */
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

    /**
     * Adds a Responsible directly to the responsibles list.
     * Ignores duplicates.
     *
     * @param r the Responsible to add
     */
    public void addResponsible(Responsible r) {
        if (r == null) return;
        if (!responsibles.contains(r)) {
            responsibles.add(r);
        } else {
            System.out.println("[Warning] Responsible with id="
                    + r.getId() + " already in the list.");
        }
    }

    /**
     * Searches for an employee by ID across both lists.
     * Returns null and prints a message if not found.
     *
     * @param id the employee ID to look for
     * @return the matching Employee (or subtype), or null
     */
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

    /**
     * Displays information for every member of staff.
     * First all regular employees, then all responsibles.
     */
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

    /**
     * Displays the full hierarchy for each responsible:
     * their info + the list of their direct subordinates.
     */
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

    /**
     * Calculates the total monthly salary to be paid to all staff.
     * Sums salaries from both lists.
     *
     * @return total monthly salary in euros
     */
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
