package employees;

// -------------------------------------------------------------------------
/**
 * Represents an average employee working 40 hours per week.
 *
 * @author Matthew Grillo mwgrillo
 * @version 1.22.2020
 */

public class Employee {
    // ~ Fields ................................................................

    private String name;
    private int employeeId;
    private double hourlyRate;


    // ~ Constructor ...........................................................
    /**
     * New Employee object.
     *
     * @param name
     *            Name of Employee
     * @param employeeId
     *            Employee ID of Employee
     * @param hourlyRate
     *            Pay rate of Employee (per hour).
     */
    public Employee(String name, int employeeId, double hourlyRate) {
        this.name = name;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
    }

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Gets the employee's name.
     * 
     * @return the employee's name
     */
    public String getName() {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Gets the employee's employee identifier.
     * 
     * @return the employee's employee identifier
     */
    public int getEmployeeId() {
        return employeeId;
    }


    // ----------------------------------------------------------
    /**
     * Gets the pay rate (per hour).
     * 
     * @return the pay rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }


    // ----------------------------------------------------------
    /**
     * Amount paid to the employee for an average 40 hour work week.
     * 
     * @return weekly Weekly pay for employee
     */
    public double weeklyPay() {
        return hourlyRate * 40;
    }


    /**
     * Test for equality between this object and another
     * 
     * @param other
     *            object to compare with
     * @return true for equality, false for inequality
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Employee otherEmp = (Employee)other;
        return (otherEmp.employeeId == this.employeeId && otherEmp.name.equals(
            this.name));
    }
}
