package io.github.crickon.lab6;

import stack.EmptyStackException;

/**
 * Stack implemented as an Array of Objects
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2.26.2020
 *
 * @param <T>
 *            Stack Object Type
 */
public class ArrayBasedStack<T> implements StackADT<T> {

    private T[] stackArray;
    private int size;
    private int capacity;


    /**
     * Default Constructor initializes the stack array with a 100 element
     * capacity
     */
    public ArrayBasedStack() {
        this(100);
    }


    /**
     * Overloaded Constructor initializes the stack array with a specified
     * capacity
     * 
     * @param initCapacity
     *            capacity of the array
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int initCapacity) {
        this.stackArray = (T[])new Object[initCapacity];
        this.size = 0;
        this.capacity = initCapacity;
    }


    /**
     * Checks if the stack is empty.
     * 
     * @return {@code true} if the stack is empty;
     *         {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the item at the top of the stack without removing it.
     *
     * @throws EmptyStackException
     *             if stack is empty.
     * 
     * @return the item at the top of the stack.
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackArray[size - 1];
    }


    /**
     * Removes the item at the top of the stack.
     *
     * @throws EmptyStackException
     *             if stack is empty.
     * 
     * @return the item at the top of the stack.
     */
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T ret = this.stackArray[size - 1];
        this.stackArray[size - 1] = null;
        this.size--;
        return ret;
    }


    /**
     * Pushes an item onto the stack.
     * 
     * @param item
     *            the item to be pushed onto the stack.
     */
    @Override
    public void push(T item) {
        if (item == null) {
            return;
        }
        if (this.size == this.capacity) {
            this.expandCapacity();
        }
        this.stackArray[size] = item;
        this.size++;
    }


    /**
     * Helper method to double the stack array's capacity
     */
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        this.capacity *= 2;
        T[] copy = (T[])new Object[this.capacity];
        for (int i = 0; i < this.size; i++) {
            copy[i] = this.stackArray[i];
        }
        this.stackArray = copy;
    }


    /**
     * Checks if an item is in the stack.
     * 
     * @param item
     *            the item to be looked for.
     * 
     * @return {@code true}, if the item is somewhere in the stack;
     *         {@code false} otherwise.
     */
    @Override
    public boolean contains(T item) {
        if (item == null) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (item.equals(this.stackArray[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * Number of items in the stack.
     * 
     * @return the number of items in the stack.
     */
    @Override
    public int size() {
        return this.size;
    }


    /**
     * Clears the stack (removes all of the items from the stack).
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        T[] newArr = (T[])new Object[this.capacity];
        this.stackArray = newArr;
        this.size = 0;
    }


    /**
     * Returns an array with a copy of each element in the stack with the top of
     * the stack being the last element
     *
     * @return the array representation of the stack
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        T[] copy = (T[])new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }


    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal;
     *         {@code false} otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !other.getClass().equals(this.getClass())) {
            return false;
        }
        ArrayBasedStack<T> oStack = (ArrayBasedStack<T>)other;
        if (this.size != oStack.size) {
            return false;
        }
        Object[] oArray = oStack.toArray();
        for (int i = 0; i < this.size; i++) {
            if (!this.stackArray[i].equals(oArray[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    public String toString() {
        // [bottom, ..., top]
        String str = "";
        for (int i = 0; i < this.size; i++) {
            str += this.stackArray[i].toString() + ", ";
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        return "[" + str + "]";

    }
}
