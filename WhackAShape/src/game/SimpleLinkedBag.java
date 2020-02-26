package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * Bag implemented as a linked list
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2.24.2020
 *
 * @param <T>
 *            Type of object
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;


    /**
     * Default constructor to initialize fields
     */
    public SimpleLinkedBag() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }


    /**
     * method to add an entry to the linked bag
     * 
     * @param arg
     *            entry to be added
     * 
     * @return success in adding the entry
     */
    @Override
    public boolean add(T arg) {
        if (arg == null) {
            return false;
        }
        Node<T> node = new Node<T>(arg);
        node.setNext(this.firstNode);

        this.firstNode = node;
        this.numberOfEntries++;
        return true;
    }


    /**
     * function to get the current size of the linked bag
     * 
     * @return number of entries in the bag
     */
    @Override
    public int getCurrentSize() {
        return this.numberOfEntries;
    }


    /**
     * method to determine if the linked bag is empty (without any elements)
     * 
     * @return the linked bag is empty
     */
    @Override
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }


    /**
     * function to randomly pick an entry from the linked bag and return its
     * value
     * 
     * @return random entry's value
     */
    @Override
    public T pick() {
        if (this.isEmpty()) {
            return null;
        }
        int index = new TestableRandom().nextInt(this.numberOfEntries);
        Node<T> current = this.firstNode;
        int count = 0;
        while (current.next() != null && count < index) {
            count++;
            current = current.next();
        }
        return current.data();
    }


    /**
     * method to remove a specific entry from the linked bag
     * 
     * @param arg
     *            to be removed
     * 
     * @return true if successful in removing the entry, false if the entry is
     *         not in the linked bag
     */
    @Override
    public boolean remove(T arg) {
        Node<T> ref = this.getReferenceTo(arg);
        if (arg == null || ref == null) {
            return false;
        }
        T dat = this.firstNode.data();
        this.firstNode.setData(ref.data());
        ref.setData(dat);

        this.firstNode = this.firstNode.next();
        this.numberOfEntries--;
        return true;
    }


    /**
     * private helper function to get the node of an entry
     * 
     * @param arg
     *            entry to find
     * 
     * @return node of the entry
     */
    private Node<T> getReferenceTo(T arg) {
        if (arg == null) {
            return null;
        }
        Node<T> current = this.firstNode;
        while (current != null) {
            T dat = current.data();
            if (dat.equals(arg)) {
                return current;
            }
        }
        return null;
    }
}
