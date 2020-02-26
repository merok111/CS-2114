package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * Bag implemented as an array
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2.24.2020
 *
 * @param <T>
 *            Type of object
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;


    /**
     * Default constructor to instantiate the array bag and number of entries
     */
    @SuppressWarnings("unchecked")
    public SimpleArrayBag() {
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;

        this.numberOfEntries = 0;
    }


    /**
     * method to add an entry to the array bag
     * 
     * @param arg
     *            entry to be added
     * 
     * @return success in adding the entry
     */
    @Override
    public boolean add(T arg) {
        if (arg != null && this.numberOfEntries < 25) {
            this.bag[this.numberOfEntries] = arg;
            this.numberOfEntries++;
            return true;
        }
        return false;
    }


    /**
     * function to get the current size of the array bag
     * 
     * @return number of entries in the bag
     */
    @Override
    public int getCurrentSize() {
        return this.numberOfEntries;
    }


    /**
     * method to determine if the array bag is empty (without any elements)
     * 
     * @return the array bag is empty
     */
    @Override
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }


    /**
     * function to randomly pick an entry from the array bag and return its
     * value
     * 
     * @return random entry's value
     */
    @Override
    public T pick() {
        if (this.isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        return this.bag[generator.nextInt(this.numberOfEntries)];
    }


    /**
     * method to remove a specific entry from the array bag
     * 
     * @param arg
     *            to be removed
     * 
     * @return true if successful in removing the entry, false if the entry is
     *         not in the array bag
     */
    @Override
    public boolean remove(T arg) {
        int i = this.getIndexOf(arg);
        if (i == -1) {
            return false;
        }
        bag[i] = bag[this.numberOfEntries - 1];
        bag[this.numberOfEntries - 1] = null;
        this.numberOfEntries--;
        return true;
    }


    /**
     * private helper function to get the index of an entry
     * 
     * @param arg
     *            entry to find
     * 
     * @return array index of the entry
     */
    private int getIndexOf(T arg) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (bag[i].equals(arg)) {
                return i;
            }
        }
        return -1;
    }

}
