package employees;

import java.util.HashMap;

/**
 * Represents an average external contractor
 * 
 * @author Matthew Grillo mwgrillo
 * @version 1.22.2020
 */
public class ExternalContractor extends Employee {

    private HashMap<Character, Double> ranks = new HashMap<Character, Double>();


    /**
     * new ExternalContractor object
     * 
     * @param name
     *            name of External Contractor
     * @param employeeId
     *            Employee number of External Contractor
     * @param hourlyRate
     *            hourly pay rate of External Contractor
     */
    public ExternalContractor(String name, int employeeId, double hourlyRate) {
        super(name, employeeId, hourlyRate);
        ranks.put('A', 38.50);
        ranks.put('B', 41.75);
        ranks.put('C', 45.50);
    }


    /**
     * get the hourly rate for a customer rank
     * 
     * @param rank
     *            The customer's rank (valid for 'A', 'B', 'C')
     * @return the hourly rate
     */
    public double getHourlyRate(char rank) {
        if (!ranks.containsKey(rank)) {
            return 0;
        }
        return ranks.get(rank);
    }


    /**
     * 
     * The amount paid per week.
     * 
     * @param hours
     *            The number of hours worked per week.
     * 
     * @param custRank
     *            The customer's rank (valid for 'A', 'B', 'C')
     * 
     * @return Returns the amount paid for a certain week.
     * 
     */
    public double weeklyPay(int hours, char custRank) {
        return hours * this.getHourlyRate(custRank);
    }
}
