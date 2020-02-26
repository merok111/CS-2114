package arraystack;

/**
 * Blueprints for a stack data structure.
 * 
 * @param <T>
 *            The type of objects that the stack will hold.
 * 
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.26
 */
public interface StackADT<T> {
    /**
     * Checks if the stack is empty.
     * 
     * @return Returns true if the stack is empty.
     */
    public boolean isEmpty();


    /**
     * Checks the item at the top of the
     * stack without removing it.
     * 
     * @return Item at the top of the stack.
     */
    public T peek();


    /**
     * Removes the item at the top of
     * the stack.
     * 
     * @return The item that was removed.
     */
    public T pop();


    /**
     * Pushes an item onto the stack.
     * 
     * @param item
     *            Item to be pushed
     *            onto the stack.
     */
    public void push(T item);


    /**
     * Checks if an item is in the stack.
     * 
     * @param item
     *            Item to be looked for.
     * @return Returns true if the item is
     *         somewhere in the stack.
     */
    public boolean contains(T item);


    /**
     * Number of items in the stack.
     * 
     * @return The number of items in
     *         the stack.
     */
    public int size();


    /**
     * Clears the stack (removes all of
     * the items from the stack).
     */
    public void clear();


    /**
     * Returns an array with a copy of each element in the stack with the top of
     * the stack being the last element
     *
     * @return the array representation of the stack
     */
    public Object[] toArray();
}
