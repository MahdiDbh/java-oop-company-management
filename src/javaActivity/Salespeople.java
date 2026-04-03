package javaActivity;

// A salesperson: base salary + commission on monthly sales
public class Salespeople extends Employee {

    private double monthlySales; // total sales for the month in euros

    private static final double COMMISSION_RATE = 0.05; // 5% commission

    // Constructor
    public Salespeople(String name, int id, hourlyRate hr, double monthlySales) {
        super(name, id, hr);
        this.monthlySales = monthlySales;
    }

    // Getter / Setter    public double getMonthlySales() { return monthlySales; }

    public void setMonthlySales(double monthlySales) {
        this.monthlySales = monthlySales;
    }

    // Total salary = base salary + 5% of monthly sales
    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double commission = COMMISSION_RATE * monthlySales;
        return baseSalary + commission;
    }

    // Prints salesperson details (sales + commission)
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
