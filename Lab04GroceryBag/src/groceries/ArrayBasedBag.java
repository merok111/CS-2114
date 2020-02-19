package groceries;

// -------------------------------------------------------------------------
/**
 * The ArrayBasedBag class is an implementation of a bag using an array.
 * It implements all methods in the BagADT plus additional methods.
 * 
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.03.24
 * @author Margaret Ellis (maellis1)
 * @version 2015.09.16
 * @author Grace Fields (sgrace)
 * @version 2016.02.01
 * @author Kanagaraj Nachimuthu Nallasamy (kanag23)
 * @version 2018.05.02
 * @author Derek Haqq (dhaqq)
 * @version 2020.02.01
 */
public class ArrayBasedBag implements BagADT {
    // The default initial capacity of the bag
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * This array holds the items in the bag
     */
    private String[] contents;
    // Actual current size
    private int size;
    // Full array size including empty items
    private int capacity;


    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public ArrayBasedBag() {
        // Call the 1-parameter constructor from this class
        this(DEFAULT_CAPACITY);
    }


    /**
     * Creates an empty bag using the specified capacity.
     * 
     * @param initialCapacity
     *            desired initial capacity of array
     */
    public ArrayBasedBag(int initialCapacity) {
        contents = new String[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }


    // ----------------------------------------------------------
    /**
     * Adds the specified element to the bag.
     * 
     * @param item
     *            to be added
     * @return Returns true if the item was successfully added.
     * @precondition parameter element is not null
     */
    @Override
    public boolean add(String item) {
        if (size < capacity) {
            contents[size] = item;
            size++;
            return true;
        }
        // if size >= capacity, there's no more room to add items
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Removes the specified element from the bag. If multiple
     * copies of the same element appear in the bag, only one is removed.
     *
     * @param target
     *            item to be removed
     * @return true if the item was removed successfully
     * @precondition parameter target is not null
     * @postcondition target item is removed
     */
    @Override
    public boolean remove(String target) {
        // Loop up until i == size instead of contents.length to avoid null
        // elements
        for (int i = 0; i < this.size(); i++) {
            if (contents[i].equals(target)) {
                // Take the last element in the array to replace contents[i]
                contents[i] = contents[size - 1];
                // Erase the entry we just moved
                contents[size - 1] = null;
                size--;
                return true;
            }
        }
        return false; // target not found
    }


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains at least 1 of the specified
     * element anywhere in the bag.
     *
     * @param target
     *            element to be found
     * @return true if target is in the bag, false otherwise
     */
    @Override
    public boolean contains(String target) {
        // Loop up until i == size instead of contents.length to avoid null
        // elements
        for (int i = 0; i < this.size(); i++) {
            if (contents[i].equals(target)) {
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains no elements.
     *
     * @return true if collection is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * A basic getter method for the private size variable.
     * Determines the number of elements currently in the bag.
     *
     * @return the number of elements in the bag
     */
    @Override
    public int size() {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Creates a copy of the underlying array as large as its capacity
     * 
     * @return Returns a copy of the underlying array data structure.
     */
    public String[] contents() {
        String[] copyContents = new String[contents.length];
        for (int i = 0; i < contents.length; i++) {
            copyContents[i] = contents[i];
        }
        return copyContents;
    }


    // ----------------------------------------------------------
    /**
     * Displays the contents in a bag using an array format with
     * brackets surrounding the contents and commas between items.
     * 
     * @return String of the bag's contents
     */
    @Override
    public String toString() {
        String returnString = "";
        // Loop up until i == size instead of contents.length to avoid null
        // elements
        for (int i = 0; i < this.size(); i++) {
            returnString += contents[i];
            // Add commas between items only if it's not the last item
            if (i != size - 1) {
                returnString += ", ";
            }
        }
        return "[" + returnString + "]";
    }


    // ----------------------------------------------------------
    /**
     * Finds the number of occurrences of a specified item in the bag.
     * 
     * @param item
     *            Item to be counted.
     * @return The number of occurrences of the item in the bag.
     */
    public int occurrence(String item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            // Use the equals method to check equality between strings
            if (contents[i].equals(item)) {
                count++;
            }
        }
        return count;
    }


    // ----------------------------------------------------------
    /**
     * Getter method for String[] contents
     * 
     * @return contents array
     */
    public String[] getContents() {
        return contents;
    }
}
