package javaActivity;

/**
 * Main class — entry point for the Company Management System.
 *
 * Creates a realistic set of employees (regular, salespeople, responsibles),
 * builds a Staff object, runs some tests and prints everything.
 */
public class Company {

    public static void main(String[] args) {

        // ---- Regular employees ----
        Employee alice = new Employee("Alice Martin",  101, hourlyRate.LOW);
        Employee bob   = new Employee("Bob Dupont",    102, hourlyRate.MEDIUM);
        Employee carol = new Employee("Carol Bernard", 103, hourlyRate.HIGH);

        // ---- Salespeople ----
        Salespeople david = new Salespeople("David Leroy", 104, hourlyRate.MEDIUM, 15000.0);
        Salespeople emma  = new Salespeople("Emma Petit",  105, hourlyRate.LOW,     8000.0);

        // ---- Responsibles ----
        Responsible frank = new Responsible("Frank Durand", 201, hourlyRate.HIGH, "Team Leader");
        Responsible grace = new Responsible("Grace Simon",  202, hourlyRate.HIGH, "Project Manager");

        // ---- Assign subordinates ----
        frank.addSubordinate(alice);
        frank.addSubordinate(bob);
        frank.addSubordinate(david);

        grace.addSubordinate(carol);
        grace.addSubordinate(emma);
        grace.addSubordinate(frank);  // Frank reports to Grace too

        // ---- Build the Staff ----
        Staff staff = new Staff();

        staff.addEmployee(alice);
        staff.addEmployee(bob);
        staff.addEmployee(carol);
        staff.addEmployee(david);
        staff.addEmployee(emma);
        staff.addEmployee(frank);  // Automatically routed to responsibles list
        staff.addEmployee(grace);

        // Duplicate test — should print a warning
        staff.addEmployee(alice);

        // ---- Display all staff ----
        staff.displayStaff();

        // ---- Display hierarchy ----
        staff.displayHierarchy();

        // ---- Search tests ----
        System.out.println("\n========== SEARCH ==========");
        Employee found = staff.searchEmployee(104);
        if (found != null) {
            found.displayEmpInfo();
        }
        staff.searchEmployee(999);  // Should say "not found"

        // ---- Total salaries ----
        System.out.println("\n========== TOTAL SALARIES ==========");
        System.out.printf("Total monthly payroll: %.2f EUR%n", staff.totalSalaries());

        // ---- Equality test ----
        System.out.println("\n========== EQUALITY TEST ==========");
        Employee aliceCopy = new Employee("Alice Copy", 101, hourlyRate.HIGH);
        System.out.println("alice.equals(aliceCopy) -> " + alice.equals(aliceCopy)); // true
        System.out.println("alice.equals(bob)       -> " + alice.equals(bob));       // false
    }
}
