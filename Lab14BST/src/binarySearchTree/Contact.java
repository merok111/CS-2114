package binarySearchTree;

/**
 * Contact object to compare first and last names and their numbers
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 5.2.2020
 *
 */
public class Contact implements Comparable<Contact> {

    private String first;
    private String last;
    private int number;


    /**
     * Construct a Contact object
     * 
     * @param f
     *            first name
     * @param l
     *            last name
     * @param num
     *            phone number
     */
    public Contact(String f, String l, int num) {
        this.first = f;
        this.last = l;
        this.number = num;
    }


    /**
     * Compares two contacts and returns how they relate to each other
     * It first compares the lastName field, then the firstName, and finally
     * the phoneNumber. If you get a positive number, the value of "this" is
     * "greater than" or "later" in the alphabet and should be placed after the
     * node.
     * for example same last name, but comparing first names:
     * "Alice".compareTo("Juan") will return negative
     * "Leron".compareTo("Juan") will return positive
     * "Juan".compareTo("Juan") will compare phoneNumber
     * 
     */
    @Override
    public int compareTo(Contact o) {
        if (o == null) {
            return 1;
        }
        if (this == o) {
            return 0;
        }

        int comp = this.first.compareTo(o.first);
        if (comp != 0) {
            return comp;
        }
        comp = this.last.compareTo(o.last);
        if (comp != 0) {
            return comp;
        }
        if (this.number > o.number) {
            return 1;
        }
        if (this.number < o.number) {
            return -1;
        }
        return 0;
    }
}
