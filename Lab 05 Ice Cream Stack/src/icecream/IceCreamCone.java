package icecream;

import java.util.Stack;

/**
 * Stack implementation of an icecream cone with each Scoop represented as a
 * String. And its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020.02.19
 */
public class IceCreamCone implements IceCreamConeADT {

    private Stack<String> flavors;
    private int numScoops;


    /**
     * Default Constructor to instantiate fields
     */
    public IceCreamCone() {
        this.flavors = new Stack<String>();
        this.numScoops = 0;
    }


    /**
     * Eat the top scoop of ice cream.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return The flavor of the scoop eaten.
     */
    public String eatScoop() {
        String scoop = null;
        if (!flavors.empty()) {
            scoop = flavors.pop();
            this.numScoops--;
        }
        return scoop;
    }


    /**
     * Add a scoop of ice cream to the top of the ice cream cone.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor of ice cream to be added.
     */
    public void addScoop(String flavor) {
        if (flavor != null) {
            flavors.push(flavor);
            this.numScoops++;
        }
    }


    /**
     * The number of scoops on the cone.
     * 
     * @return Returns the number of scoops on the cone.
     */
    public int numScoops() {
        return this.numScoops;
    }


    /**
     * Check if your cone already contains a specific flavor of ice cream.
     * 
     * @precondition The flavor isn't null.
     * @param flavor
     *            Flavor to be checked for.
     * @return Returns true if the cone already contains the desired flavor.
     */
    public boolean contains(String flavor) {
        if (flavor == null || this.numScoops == 0) {
            return false;
        }
        boolean contains = false;
        Stack<String> temp = new Stack<String>();
        while (!this.flavors.isEmpty()) {
            String element = flavors.pop();
            if (element.equals(flavor)) {
                contains = true;
                break;
            }
            temp.push(element);
        }
        while (!temp.isEmpty()) {
            this.flavors.push(temp.pop());
        }
        return contains;
    }


    /**
     * Checks if any scoops of ice cream are left.
     * 
     * @return Returns true if there are no ice cream scoops left in the cone.
     */
    public boolean emptyCone() {
        return this.numScoops == 0;
    }


    /**
     * The flavor of the ice cream at the top of the cone.
     * 
     * @precondition There exists at least one flavor of ice cream in the ice
     *               cream cone. (The cone isn't empty).
     * @return Returns the flavor of the top of the cone.
     */
    public String currentScoop() {
        if (this.flavors.isEmpty()) {
            return null;
        }
        return flavors.peek();
    }


    /**
     * Returns a string representation of the ice cream cone. Format: The
     * flavors are surrounded by brackets: [] The flavors are separated by
     * commas. Example: [Vanilla, Chocolate, Rocky Road] Orientation: Flavors
     * are appended to the right when pushed onto the stack. Flavors are removed
     * from the right when popped off the stack.
     * 
     * @return The string of the ice cream flavors.
     */
    @Override
    public String toString() {
        // [Bottom, Top]
        String inn = "";
        Stack<String> temp = new Stack<String>();
        while (!flavors.isEmpty()) {
            String element = flavors.pop();
            inn = element + ", " + inn;
            temp.push(element);
        }
        while (!temp.isEmpty()) {
            flavors.push(temp.pop());
        }
        if (inn.length() != 0) {
            inn = inn.substring(0, inn.length() - 2);
        }
        return "[" + inn + "]";
    }


    /**
     * Test for equality between this object and another
     * 
     * @param other
     *            Object to check with this class
     * @return boolean correlating to equality
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other == null) || (other.getClass() != IceCreamCone.class)) {
            return false;
        }
        return flavors.equals(((IceCreamCone)other).flavors);
    }

}
