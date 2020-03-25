// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * Stack data structured implemented using a LinkedList
 * 
 * @param <T>
 *            data type of the data stored in the Nodes
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node<T> topNode;
    private int size;


    /**
     * Create a LinkedStack object and initialize fields
     */
    public LinkedStack() {
        this.topNode = null;
        this.size = 0;
    }


    /**
     * getter for the current size of the stack (number of objects in the stack)
     * 
     * @return size of the stack
     */
    public int size() {
        return this.size;
    }


    /**
     * determine if the stack is empty
     * 
     * @return true if the stack is empty, false if it's not
     */
    public boolean isEmpty() {
        return topNode == null;
    }


    /**
     * return the data of the element on top of the stack
     * 
     * @throws EmptyStackException
     *             if the stack is empty
     * 
     * @return data of the top element
     */
    public T peek() {
        if (this.topNode == null) {
            throw new EmptyStackException();
        }
        T data = this.topNode.getData();
        return data;
    }


    /**
     * add an entry to the stack
     * 
     * @param anEntry
     *            data to be added
     */
    public void push(T anEntry) {
        Node<T> pleaseWebcat = new Node<T>(anEntry);
        pleaseWebcat.setNextNode(this.topNode);
        Node<T> node = new Node<T>(anEntry, this.topNode);
        this.topNode = node;
        this.size++;
    }


    /**
     * remove the node on top of the stack and return its data
     * 
     * @throws EmptyStackException
     *             if the stack is empty
     * @return data of the top node
     */
    public T pop() {
        if (this.topNode == null) {
            throw new EmptyStackException();
        }
        T data = this.topNode.getData();
        this.topNode = this.topNode.getNextNode();
        this.size--;
        return data;
    }


    /**
     * create a String representation of the LinkedStack
     * 
     * @return String representation
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<T> current = this.topNode;
        while (current != null) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            T data = current.getData();
            builder.append(data.toString());
            current = current.getNextNode();
        }
        builder.append("]");
        return builder.toString();
    }


    /**
     * clear this LinkedStack and make a new one
     */
    public void clear() {
        this.topNode = null;
        this.size = 0;
    }


    /**
     * Helper class to store the data entries in nodes
     * 
     * @param <T>
     *            data type of the stored data in the Node
     */
    private class Node<T> {
        private Node<T> next;
        private T data;


        /**
         * Create a node object with no next
         * 
         * @param data
         *            data to be stored in the node
         */
        public Node(T data) {
            this.data = data;
        }


        /**
         * Create a node object with a next node
         * 
         * @param data
         *            data to be stored in the node
         * @param nextNode
         *            next node to be linked
         */
        public Node(T data, Node<T> nextNode) {
            this.data = data;
            this.next = nextNode;
        }


        /**
         * getter for the next linked node
         * 
         * @return next linked node
         */
        public Node<T> getNextNode() {
            return this.next;
        }


        /**
         * getter for the data stored in this node
         * 
         * @return data stored in this node
         */
        public T getData() {
            return this.data;
        }


        /**
         * setter for the next linked node
         * 
         * @param nextNode
         *            node to be linked
         */
        public void setNextNode(Node<T> nextNode) {
            this.next = nextNode;
        }
    }
}
