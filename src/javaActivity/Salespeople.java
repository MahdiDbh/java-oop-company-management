package javaActivity;

/**
 * Represents a salesperson employee.
 *
 * In addition to the base salary, salespeople earn a commission
 * based on their monthly sales figure.
 *
 * Assumption: commission rate is 5% of monthly sales.
 * This felt like a reasonable default — it can easily be changed
 * by updating COMMISSION_RATE.
 *
 * Extends Employee.
 */
public class Salespeople extends Employee {

    // Total sales amount for the current month (in euros)
    private double monthlySales;

    // 5% commission on sales — assumption documented here
    private static final double COMMISSION_RATE = 0.05;

    /**
     * Constructor.
     *
     * @param name         the salesperson's name
     * @param id           unique employee ID
     * @param hr           hourly rate category
     * @param monthlySales total sales this month in euros
     */
    public Salespeople(String name, int id, hourlyRate hr, double monthlySales) {
        super(name, id, hr);
        this.monthlySales = monthlySales;
    }

    // --- Getter / Setter ---

    public double getMonthlySales() { return monthlySales; }

    public void setMonthlySales(double monthlySales) {
        this.monthlySales = monthlySales;
    }

    /**
     * Overrides calculateSalary() to include sales commission.
     *
     * Total Salary = base salary + (5% * monthlySales)
     *
     * @return total monthly salary including commission
     */
    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double commission = COMMISSION_RATE * monthlySales;
        return baseSalary + commission;
    }

    /**
     * Prints the salesperson's details including sales figures.
     */
    public void printSalespeopleDetails() {
        System.out.println("==============================");
        System.out.println("SALESPERSON");
        System.out.println("Name          : " + name);
        System.out.println("ID            : " + id);
        System.out.println("Rate          : " + hr + " (" + hr.hourlyRate() + " EUR/h)");
        System.out.printf( "Monthly Sales : %.2f EUR%n", monthlySales);
        System.out.printf( "Commission    : %.2f EUR (%.0f%%)%n",
                            COMMISSION_RATE * monthlySales,
                            COMMISSION_RATE * 100);
        System.out.printf( "Total Salary  : %.2f EUR%n", calculateSalary());
    }

    /**
     * Override displayEmpInfo() to show salesperson-specific details.
     */
    @Override
    public void displayEmpInfo() {
        printSalespeopleDetails();
    }

    @Override
    public String toString() {
        return "Salespeople[id=" + id + ", name=" + name
                + ", sales=" + monthlySales + "]";
    }
}
