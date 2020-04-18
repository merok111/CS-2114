package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 100;

    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    public ArrayQueue() {
        this.clear();
    }


    public int getLength() {
        return this.queue.length;
    }


    public int getSize() {
        return this.size;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }


    private boolean maxCap() {
        return this.size == MAX_CAPACITY;
    }


    public void enqueue(T obj) {
        ensureCapacity();
        queue[this.enqueueIndex] = obj;
        this.enqueueIndex = this.incrementIndex(this.enqueueIndex);
        this.size++;
    }


    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (!this.maxCap()) {
            if (this.size == this.getLength() - 1) {
                T[] temp = (T[])new Object[size * 2 + 1];
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


    public T dequeue() {
        T ret = this.getFront();
        queue[this.dequeueIndex] = null;
        this.dequeueIndex = this.incrementIndex(this.dequeueIndex);
        this.size--;
        return ret;
    }


    public T getFront() {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[this.dequeueIndex];
    }


    @SuppressWarnings("unchecked")
    public void clear() {
        this.queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.enqueueIndex = 0;
        this.dequeueIndex = 0;
    }


    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    public Object[] toArray() {
        return this.queue.clone();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (T element : queue) {
            builder.append(element.toString() + ", ");
        }
        if (builder.length() > 1) {
            builder.delete(builder.lastIndexOf(","), builder.length());
        }
        builder.append("]");
        return builder.toString();
    }


    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        if (obj.getClass().equals(this.getClass())) {
            ArrayQueue<T> other = (ArrayQueue<T>)obj;
            for (int i = this.dequeueIndex; i != this.enqueueIndex; this
                .incrementIndex(i)) {
                T myElement = queue[i];
                T otherElement = other.queue[i];
                if (!myElement.equals(otherElement)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
