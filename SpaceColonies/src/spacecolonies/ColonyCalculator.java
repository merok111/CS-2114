// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

import list.AList;

/**
 * ColonyCalculator class to handle determining which Persons should go to which
 * planets, or reject those that do not meet criteria
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class ColonyCalculator {
    /**
     * number of planets in this project
     */
    public static final int NUM_PLANETS = 3;
    /**
     * the minimum skill level of this project
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * the maximum skill level of this project
     */
    public static final int MAX_SKILL_LEVEL = 5;

    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS];


    /**
     * Construct the ColonyCalculator
     * 
     * @param people
     *            people in the ArrayQueue
     * @param planets
     *            planets for the people to go to
     */
    public ColonyCalculator(ArrayQueue<Person> people, Planet[] planets) {
        if (people == null) {
            throw new IllegalArgumentException("ArrayQueue can not be null");
        }
        this.applicantQueue = people;
        ColonyCalculator.planets = planets;
        this.rejectBus = new AList<Person>();
    }


    /**
     * method to get the queue of people
     * 
     * @return ArrayQueue of Persons
     */
    public ArrayQueue<Person> getQueue() {
        return this.applicantQueue;
    }


    /**
     * 
     * method to get the Planets
     * 
     * @return Planet array
     */
    public static Planet[] getPlanets() {
        return planets;
    }


    /**
     * Determine which planet would be the best for a Person, preference comes
     * first and the most available second
     * 
     * @param nextPerson
     *            Person to be placed
     * @return the best Planet
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null || applicantQueue.isEmpty()) {
            return null;
        }
        String preference = nextPerson.getPlanetPreference();
        Planet pref = null;
        Planet mostAvailible = null;
        for (Planet planet : planets) {
            if (planet != null) {
                if (pref == null && planet.getName().equals(preference)
                    && !planet.isFull()) {
                    pref = planet;
                }
                if (planet.compareTo(mostAvailible) >= 0) {
                    mostAvailible = planet;
                }
            }
        }
        if (pref == null || pref.isFull() || !pref.isQualified(nextPerson)) {
            if (mostAvailible == null || mostAvailible.isFull()
                || !mostAvailible.isQualified(nextPerson)) {
                return null;
            }
            return mostAvailible;
        }
        return pref;
    }


    /**
     * Test the next person in the queue to see if a Planet fits for them. If
     * one is found, remove them from the queue and add the person to that
     * planet
     * 
     * @return successfully added the person to a planet
     */
    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        Person person = applicantQueue.getFront();
        Planet planet = this.getPlanetForPerson(person);
        if (planet == null || person == null) {
            return false;
        }
        planet.addPerson(person);
        this.applicantQueue.dequeue();
        return true;
    }


    /**
     * method to reject the next person in the queue
     */
    public void reject() {
        if (applicantQueue.isEmpty()) {
            return;
        }
        Person person = applicantQueue.dequeue();
        this.rejectBus.add(person);
    }


    /**
     * Find the Planet that corresponds to the number given
     * 
     * @param planet
     *            number
     * @return Planet object
     */
    public Planet planetByNumber(int planet) {
        if (planet >= 1 && planet <= NUM_PLANETS) {
            return planets[planet - 1];
        }
        return null;
    }


    /**
     * Get the planet index from the name of the planet. Returns -1 if no index
     * is found
     * 
     * @param planet
     *            name of the planet
     * @return index in the Planet array
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i] != null && planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }

}
