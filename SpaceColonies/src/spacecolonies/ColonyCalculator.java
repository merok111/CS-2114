package spacecolonies;

import list.AList;

public class ColonyCalculator {
    public static final int NUM_PLANETS = 3;
    public static final int MIN_SKILL_LEVEL = 1;
    public static final int MAX_SKILL_LEVEL = 5;

    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];


    public ColonyCalculator(ArrayQueue<Person> people, Planet[] planets) {
        if (people == null) {
            throw new IllegalArgumentException("ArrayQueue can not be null");
        }
        this.applicantQueue = people;
        ColonyCalculator.planets = planets;
        this.rejectBus = new AList<Person>();
    }


    public ArrayQueue<Person> getQueue() {
        return this.applicantQueue;
    }


    public Planet[] getPlanets() {
        return planets;
    }


    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null || applicantQueue.isEmpty()) {
            return null;
        }
        String preference = nextPerson.getPlanetPreference();
        Planet pref = null;
        Planet mostAvailible = null;
        for (Planet planet : planets) {
            if (pref == null && planet.getName().equals(preference) && !planet
                .isFull()) {
                pref = planet;
            }
            if (planet.compareTo(mostAvailible) >= 0) {
                mostAvailible = planet;
            }
        }
        if (pref == null) {
            if (mostAvailible == null || mostAvailible.isFull()) {
                return null;
            }
            return mostAvailible;
        }
        return pref;
    }


    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        Person person = applicantQueue.getFront();
        Planet planet = this.getPlanetForPerson(person);
        if (planet == null) {
            return false;
        }
        planet.addPerson(person);
        this.applicantQueue.dequeue();
        return true;
    }


    public void reject() {
        if (applicantQueue.isEmpty()) {
            return;
        }
        Person person = applicantQueue.dequeue();
        this.rejectBus.add(person);
    }


    public Planet planetByNumber(int planet) {
        if (planet >= 1 || planet <= 3)
            return planets[planet];
        return null;
    }


    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return 0;
    }

}
