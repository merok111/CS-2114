package groceries;

// -------------------------------------------------------------------------
/**
 * The BagADT interface defines the operations for a bag collection.
 * 
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.03.24
 * @author Grace Fields (sgrace)
 * @version 2016.02.01
 */
public interface BagADT {
    /**
     * Adds the specified element to the bag.
     * 
     * @param item
     *            Item to be added
     * @return Returns true if the item was successfully added.
     * @precondition parameter element is not null
     */
    public boolean add(String item);


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
    public boolean remove(String target);


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains at least 1 of the specified
     * element anywhere in the bag.
     *
     * @param target
     *            element to be found
     * @return true if target is in the bag, false otherwise
     */
    public boolean contains(String target);


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains no elements.
     *
     * @return true if collection is empty, false otherwise
     */
    public boolean isEmpty();


    // ----------------------------------------------------------
    /**
     * A basic getter method for the private size variable.
     * Determines the number of elements currently in the bag.
     *
     * @return the number of elements in the bag
     */
    public int size();
}
