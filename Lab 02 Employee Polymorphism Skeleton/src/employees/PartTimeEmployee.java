package employees;

/**
 * Represents an average part time employee
 *
 * @author Matthew Grillo mwgrillo
 * @version 1.22.2020
 */
public class PartTimeEmployee extends Employee {
    private int hoursWorked;


    /**
     * new PartTimeEmployee object
     * 
     * @param name
     *            name of Employee
     * @param employeeId
     *            Employee ID of Employee
     * @param hourlyRate
     *            hourly pay rate of Employee
     * @param hoursWorked
     *            hours worked by Employee
     */
    public PartTimeEmployee(
        String name,
        int employeeId,
        double hourlyRate,
        int hoursWorked) {
        super(name, employeeId, hourlyRate);
        this.hoursWorked = hoursWorked;
    }


    /**
     * get the number of hours worked by Employee
     * 
     * @return number of hours worked
     */
    public int getHoursWorked() {
        return this.hoursWorked;
    }


    /**
     * calculate the weekly pay for the Employee
     * 
     * @return Employee's weekly pay
     */
    @Override
    public double weeklyPay() {
        return this.hoursWorked * super.getHourlyRate();
    }

}
