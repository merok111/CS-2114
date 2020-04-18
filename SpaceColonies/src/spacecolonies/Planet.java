package spacecolonies;

public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private int capacity;


    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        this.name = planetName;
        this.minSkills = new Skills(planetAgri, planetMedi, planetTech);
        this.capacity = planetCap;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Skills getMinSkills() {
        return minSkills;
    }


    public Person[] getPopulation() {
        return population;
    }


    public int getPopulationSize() {
        return populationSize;
    }


    public int getCapacity() {
        return capacity;
    }


    public int getAvailability() {
        return this.capacity - this.populationSize;
    }


    public boolean isFull() {
        return this.capacity == this.populationSize;
    }


    public boolean addPerson(Person newbie) {
        if (!isFull() && isQualified(newbie)) {
            this.population[this.populationSize] = newbie;
            this.populationSize++;
            return true;
        }
        return false;
    }


    private boolean isQualified(Person applicant) {
        return !applicant.getSkills().isBelow(this.minSkills);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        // "Caturn, population 5 (cap: 10), Requires: A >= 3, M >= 2, T >= 1"
        builder.append(this.name + ", ");
        builder.append("population ");
        builder.append(this.populationSize);
        builder.append("(cap: " + this.capacity + "), ");
        builder.append("Requires: ");
        builder.append("A >= " + this.minSkills.getAgriculture());
        builder.append("M >= " + this.minSkills.getMedicine());
        builder.append("T >= " + this.minSkills.getTechnology());
        return builder.toString();
    }


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


    @Override
    public int compareTo(Planet other) {
        return this.getAvailability() - other.getAvailability();
    }

}
