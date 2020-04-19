package spacecolonies;

public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;


    public Skills(int ag, int med, int tech) {
        this.agriculture = ag;
        this.medicine = med;
        this.technology = tech;
    }


    public int getAgriculture() {
        return this.agriculture;
    }


    public int getMedicine() {
        return this.medicine;
    }


    public int getTechnology() {
        return this.technology;
    }


    public boolean isBelow(Skills other) {
        return this.agriculture < other.agriculture
            && this.medicine < other.medicine
            && this.technology < other.technology;
    }


    @Override
    public String toString() {
        return "A:" + this.agriculture + " M:" + this.medicine + " T:"
            + this.technology;
    }


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
