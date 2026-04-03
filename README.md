# Company Management System — Java OOP


A Java project built around **inheritance** and **object-oriented design**, modelling a company's employee management system.

---

## Project Structure

```
CompanyManagementSystem/
├── src/
│   └── javaActivity/
│       ├── hourlyRate.java      # Enum: LOW / MEDIUM / HIGH hourly rates
│       ├── Employee.java        # Base class — all employees
│       ├── Responsible.java     # Subclass — managers with subordinates
│       ├── Salespeople.java     # Subclass — salespeople with commission
│       ├── Staff.java           # Manages the full company staff
│       └── Company.java        # Main class — entry point
└── README.md
```

---

## Class Hierarchy

```
Comparable<Employee>
        │
   Employee
   ├── Responsible    (title + list of subordinates)
   └── Salespeople    (monthly sales + commission)

Staff     (holds all employees & responsibles)
Company   (main method)
hourlyRate (enum)
```

---

## Features

| Class | Key behaviour |
|---|---|
| `hourlyRate` | Enum with 3 levels: `LOW(24)`, `MEDIUM(28)`, `HIGH(32)` EUR/h |
| `Employee` | Base salary = rate × 160 h. Equality based on `id`. |
| `Responsible` | Has a title and a list of direct subordinates. |
| `Salespeople` | Salary = base salary + **5% commission** on monthly sales. |
| `Staff` | Two lists (employees / responsibles). Search, display, total salary. |
| `Company` | Demo: creates employees, builds staff, runs all features. |

---

## How to Compile & Run

```bash
# From the project root
javac -d out src/javaActivity/*.java

# Run
java -cp out javaActivity.Company
```

---

## Design Decisions

- **`protected` fields in `Employee`** — subclasses access them directly without going through getters in every single method. Simpler code.
- **Two separate lists in `Staff`** — keeps `Responsible` out of `employees` so `totalSalaries()` doesn't double-count them.
- **5% commission for salespeople** — a reasonable assumption, documented in the code as a named constant so it's easy to change.
- **`instanceof` routing in `addEmployee()`** — automatically sends `Responsible` objects to the right list so the caller doesn't have to worry about it.

