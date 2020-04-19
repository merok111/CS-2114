package spacecolonies;

public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;


    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        this.skills = new Skills(agri, medi, tech);
        this.planetPreference = planet;
    }


    public String getName() {
        return this.name;
    }


    public Skills getSkills() {
        return this.skills;
    }


    public String getPlanetPreference() {
        return this.planetPreference;
    }


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
