// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Planet object to store the planets name, minimum skill requirements and
 * population
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private int capacity;


    /**
     * Create a Planet object with the given information
     * 
     * @param planetName
     *            name of the Planet
     * @param planetAgri
     *            minimum agricultural skill level
     * @param planetMedi
     *            minimum medical skill level
     * @param planetTech
     *            minimum technical skill level
     * @param planetCap
     *            capacity of the Planet
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        this.name = planetName;
        this.minSkills = new Skills(planetAgri, planetMedi, planetTech);
        this.capacity = planetCap;
        this.population = new Person[capacity];
    }


    /**
     * method to get the name of the planet
     * 
     * @return name of the planet
     */
    public String getName() {
        return name;
    }


    /**
     * method to set the name of the planet
     * 
     * @param name
     *            name to be set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * method to get the minimum skills for this planet stored as a Skill object
     * 
     * @return minimum Skills
     */
    public Skills getMinSkills() {
        return minSkills;
    }


    /**
     * method to get the population array of Persons
     * 
     * @return array of Persons
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * method to get the population size of the planet
     * 
     * @return population size of the planet
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * method to get the capacity of the planet
     * 
     * @return capacity of the planet
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * method to get the number of spots left available
     * 
     * @return number of more people the planet can hold
     */
    public int getAvailability() {
        return this.capacity - this.populationSize;
    }


    /**
     * method to determine if this planet is full
     * 
     * @return if the planet is full
     */
    public boolean isFull() {
        return this.capacity == this.populationSize;
    }


    /**
     * method to add a Person to this planet
     * 
     * @param newbie
     *            Person to be added to the population
     * @return successfully added the Person
     */
    public boolean addPerson(Person newbie) {
        if (!isFull() && isQualified(newbie)) {
            this.population[this.populationSize] = newbie;
            this.populationSize++;
            return true;
        }
        return false;
    }


    /**
     * determine if a Person is qualified in their skill levels to be accepted
     * onto this planet
     * 
     * @param applicant
     *            Person to check
     * @return if they are qualified
     */
    public boolean isQualified(Person applicant) {
        return this.minSkills.isBelow(applicant.getSkills());
    }


    /**
     * Generate a String representation of this Planet
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // "Caturn, population 5 (cap: 10), Requires: A >= 3, M >= 2, T >= 1"
        builder.append(this.name + ", ");
        builder.append("population ");
        builder.append(this.populationSize);
        builder.append(" (cap: " + this.capacity + "), ");
        builder.append("Requires: ");
        builder.append("A >= " + this.minSkills.getAgriculture());
        builder.append(", M >= " + this.minSkills.getMedicine());
        builder.append(", T >= " + this.minSkills.getTechnology());
        return builder.toString();
    }


    /**
     * Determine if this class is equal to another object
     * 
     * @param obj
     *            other object
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
            Planet other = (Planet)obj;
            return this.toString().equals(other.toString());
        }
        return false;
    }


    /**
     * Compare this Planet to another using availability.
     * 
     * @param other
     *            other Planet
     * @return difference in this availability to the other
     */
    @Override
    public int compareTo(Planet other) {
        if (other == null) {
            return 1;
        }
        return this.getAvailability() - other.getAvailability();
    }

}
