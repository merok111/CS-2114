package binarySearchTree;

/**
 *  This provides method definitions for the base functions of a
 *  binary search tree
 *  @param <T> the class that this works with
 *  @author Mark Allen Weiss (with modifications by John Lewis)
 *  @version 04.30.2015
 */
public interface BinarySearchTree<T>
{

    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void insert(T x);

    /**
     * Remove the specified value from the tree.
     * @param x the item to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove(T x);

    /**
     * Find the smallest item in the tree.
     * @return The smallest item, or null if the tree is empty.
     */
    public T findMin();

    /**
     * Find the largest item in the tree.
     * @return The largest item in the tree, or null if the tree is empty.
     */
    public T findMax();

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public T find(T x);

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty();

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty();
}
