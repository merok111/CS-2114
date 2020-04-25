// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Skills Data Structor to store the skills of different categories
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * Construct the Skills class with information given
     * 
     * @param ag
     *            agricultural skill level
     * @param med
     *            medical skill level
     * @param tech
     *            technical skill level
     */
    public Skills(int ag, int med, int tech) {
        this.agriculture = ag;
        this.medicine = med;
        this.technology = tech;
    }


    /**
     * method to get the agricultural skill level
     * 
     * @return ag skill level
     */
    public int getAgriculture() {
        return this.agriculture;
    }


    /**
     * method to get the medical skill level
     * 
     * @return med skill level
     */
    public int getMedicine() {
        return this.medicine;
    }


    /**
     * method to get the technical skill level
     * 
     * @return tech skill level
     */
    public int getTechnology() {
        return this.technology;
    }


    /**
     * Determine if another Skills class's values are all below this class'
     * 
     * @param other
     *            other Skill class
     * @return other Skills are below these ones
     */
    public boolean isBelow(Skills other) {
        return this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology;
    }


    /**
     * Generate a String representation of this object
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        return "A:" + this.agriculture + " M:" + this.medicine + " T:"
            + this.technology;
    }


    /**
     * Determine if this class is equal to another object
     * 
     * @param obj
     *            other object
     * 
     * @return if this class is equal to the other object
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Skills other = (Skills)obj;
            if (other.agriculture == this.agriculture
                && other.medicine == this.medicine
                && other.technology == this.technology) {
                return true;
            }
        }
        return false;
    }
}
