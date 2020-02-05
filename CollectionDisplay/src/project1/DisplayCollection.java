// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package project1;

import java.util.Random;
import bag.Bag;
import bag.BagInterface;

/**
 * Creates the Bag collection to be displayed
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020-02-05
 *
 */
public class DisplayCollection {
    /**
     * constant string array to fill the contents of the bag with
     */
    public static final String[] STRINGS = { "red circle", "blue circle",
        "red square", "blue square" };

    private BagInterface<String> itemBag;


    /**
     * initialize the item bag and add a random number (from 5 to 15) of String
     * to it
     */
    public DisplayCollection() {
        this.itemBag = new Bag<>();
        Random random = new Random();
        int count = random.nextInt(11) + 5;
        for (int i = 0; i < count; i++) {
            this.itemBag.add(STRINGS[(int)(Math.random() * 4)]);
        }
    }


    /**
     * Getter for the itemBag field
     * 
     * @return the item bag
     */
    public BagInterface<String> getItemBag() {
        return this.itemBag;
    }
}
