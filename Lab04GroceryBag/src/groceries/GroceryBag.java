package groceries;

// -------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects
 * that represent grocery store items.
 *
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.25
 * @author Grace Fields
 * @version 2016.02.01
 * @author Matthew Grillo (mwgrillo)
 * @version 2020.02.12
 */
public class GroceryBag extends ArrayBasedBag {
    // Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag() {
        super(10);
    }


    // Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the
     * intersection. If there are multiple occurrences of that
     * element, then the number of occurrences of that element
     * in the intersection will equal the minimum number of occurrences
     * in either set.
     * 
     * Examples:
     * intersection of
     * ({"apple","apple","cereal","chips"},
     * {"chips", "apple","apple","chips","cake"})
     * = {"apple","apple","chips"}
     * 
     * @param bag
     *            Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag) {
        String[] one = this.contents();
        String[] two = bag.contents();
        GroceryBag intersection = new GroceryBag();
        for (int i = 0; i < one.length; i++) {
            if (one[i] != null) {
                for (int j = 0; j < two.length; j++) {
                    if (one[i] != null && two[j] != null && one[i].equals(
                        two[j])) {
                        intersection.add(one[i]);
                        one[i] = null;
                        two[j] = null;
                    }
                }
            }
        }
        return intersection;

    }


    /**
     * For two bags to be equal they need to contain items
     * with the exact same value (but not the same item, so
     * equality not identity). Order does not matter, but
     * number of occurrences does.
     * 
     * @param givenBag
     *            Other GroceryBag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag) {
        if (givenBag == null) {
            return false;
        }
        if (givenBag == this) {
            return true;
        }
        if (givenBag.getClass() != this.getClass()) {
            return false;
        }
        GroceryBag other = (GroceryBag)givenBag;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.occurrence(this.contents()[i]) != other.occurrence(other
                .contents()[i])) {
                return false;
            }
        }
        return true;
    }
}
