// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * Queue Data Structure implemented as a circle array
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 * @param <T>
 *            elements data type
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 100;

    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    /**
     * Default Constructor to initialize array and fields
     */
    public ArrayQueue() {
        this.clear();
    }


    /**
     * method to get the length of the queue
     * 
     * @return
     *         number of slots in the queue, filled and not filled
     */
    public int getLength() {
        return this.queue.length;
    }


    /**
     * method to get the current size of the queue
     * 
     * @return
     *         number of elements in the queue
     */
    public int getSize() {
        return this.size;
    }


    /**
     * function to return true if the queue is empty
     * 
     * @return if the queue is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * function to return if the queue has reached maximum capacity
     * 
     * @return if the queue reached maximum capacity
     */
    private boolean maxCap() {
        return this.size == MAX_CAPACITY;
    }


    /**
     * method to add an element to the queue
     * 
     * @param obj
     *            object to be added
     */
    public void enqueue(T obj) {
        ensureCapacity();
        queue[this.enqueueIndex] = obj;
        this.enqueueIndex = this.incrementIndex(this.enqueueIndex);
        this.size++;
    }


    /**
     * helper method to ensure that the capacity of the array can handle more
     * elements
     * 
     * @throws IllegalStateException
     *             if the array has reached maximum capacity
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (!this.maxCap()) {
            if (this.size == this.getLength() - 1) {
                T[] temp = (T[])new Object[this.getSize() * 2 + 1];
                for (int i = 0; i < this.getLength(); i++) {
                    temp[i] = this.queue[i];
                }
                this.enqueueIndex = size;
                this.queue = temp;
            }
            return;
        }
        throw new IllegalStateException("The Array has reached Max Capacity");
    }


    /**
     * method to remove the first element from the queue
     * 
     * @return first element
     */
    public T dequeue() {
        T ret = this.getFront();
        queue[this.dequeueIndex] = null;
        this.dequeueIndex = this.incrementIndex(this.dequeueIndex);
        this.size--;
        return ret;
    }


    /**
     * method to peek at the first element in the queue
     * 
     * @return first element
     */
    public T getFront() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[this.dequeueIndex];
    }


    /**
     * method to clear the queue and refresh fields
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        this.queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.enqueueIndex = 0;
        this.dequeueIndex = 0;
    }


    /**
     * helper method to increment an index, but bound to the length of the queue
     * 
     * @param index
     *            index to increment
     * @return incremented index
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * function to get a array copy of the queue
     * 
     * @return Object array copy of the queue
     */
    public Object[] toArray() {
        return this.queue.clone();
    }


    /**
     * Generate a String representation of the ArrayQueue
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (T element : queue) {
            if (element != null) {
                builder.append(element.toString() + ", ");
            }
        }
        if (builder.length() > 1) {
            builder.delete(builder.lastIndexOf(","), builder.length());
        }
        builder.append("]");
        return builder.toString();
    }


    /**
     * Check if this ArrayQueue is equals to another object
     * 
     * @param obj
     *            to be checked
     * @return this ArrayQueue equals another object
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        if (obj.getClass().equals(this.getClass())) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)obj;
            /*
             * if (this.enqueueIndex != other.enqueueIndex
             * || this.dequeueIndex != other.dequeueIndex) {
             * return false;
             * }
             */
            for (int i = 0; i < this.getLength(); i++) {
                T myElement = queue[i];
                T otherElement = other.queue[i];
                if (myElement != null && otherElement != null) {
                    if (!myElement.equals(otherElement)) {
                        return false;
                    }
                }
                else if (!(myElement == null && otherElement == null)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
