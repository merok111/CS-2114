// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Person Data Structure to store name, skills and planet preference
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * Construct a new Person Object
     * 
     * @param name
     *            name of the person
     * @param agri
     *            agricultural skill of the person
     * @param medi
     *            medical skill of the person
     * @param tech
     *            technical skill of the person
     * @param planet
     *            planet preference
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        this.skills = new Skills(agri, medi, tech);
        this.planetPreference = planet;
    }


    /**
     * method to get the name of this person
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }


    /**
     * method to get the skills of this person
     * 
     * @return skills
     */
    public Skills getSkills() {
        return this.skills;
    }


    /**
     * 
     * method to get the planet preference of this person
     * 
     * @return planet preference
     */
    public String getPlanetPreference() {
        return this.planetPreference;
    }


    /**
     * Generate a String representation of this Person
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        // concatenate the name, the first letter for each skill (in
        // alphabetical order) and a colon, then the skill value.
        StringBuilder builder = new StringBuilder();
        builder.append(this.name + " ");
        builder.append(this.skills.toString());
        if (this.planetPreference.length() > 0) {
            builder.append(" Wants: " + this.planetPreference);
        }
        return builder.toString();
    }


    /**
     * Check if this class is equals to another object
     * 
     * @param obj
     *            Object to test
     * @return if this class equals the other object
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Person other = (Person)obj;
            if (this.name.equals(other.name) && this.skills.equals(other.skills)
                && this.planetPreference.equals(other.planetPreference)) {
                return true;
            }
        }
        return false;
    }

}
