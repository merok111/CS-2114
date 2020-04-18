package cybersecurity.lab1;

import cybersecurity.KVStore;

/**
 * An interface for the LinkedKVStore
 * 
 * @author victoriahairston1
 * @version 28.3.17
 * @param <K>
 *            the type of the key
 * @param <V>
 *            the type of the value
 */
public interface LinkedKVStoreInterface<K, V> extends KVStore<K, V> {
    /**
     * Returns true if this list contains no elements.
     * 
     * @return true if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     * 
     * @return the number of elements in this list
     */
    public int size();

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns.
     */
    public void clear();

    /**
     * Returns the first occurrence of the specified element in this list (when
     * traversing from head to tail). If this list contains an entry for the
     * specified key, the associated value is returned; otherwise, null is
     * returned.
     * 
     * @param key
     *            a key in this list
     * @return the value to which the key is mapped in this list
     */
    public V getFirst(K key);

    /**
     * Returns the last occurrence of the specified element in this list (when
     * traversing from head to tail). If this list contains an entry for the
     * specified key, the associated value is returned; otherwise, null is
     * returned.
     * 
     * @param key
     *            a key in this list
     * @return the value to which the key is mapped in this list
     */
    public V getLast(K key);

    /**
     * Inserts the key (and its corresponding value) at the beginning of this
     * list.
     * 
     * @param key
     *            the key to be inserted
     * @param value
     *            the value to which the key will be mapped
     */
    public void addFirst(K key, V value);

    /**
     * Inserts the key (and its corresponding value) at the end of this list.
     * 
     * @param key
     *            the key to be inserted
     * @param value
     *            the value to which the key will be mapped
     */
    public void addLast(K key, V value);

    /**
     * Removes the first occurrence of the key (and its corresponding value) in
     * this list (when traversing the list from head to tail). If the list does
     * not contain the key, it is unchanged.
     * 
     * @param key
     *            the key that needs to be removed, if present
     * @return true if the list contained the specified element
     */
    public boolean removeFirst(K key);

    /**
     * Removes the last occurrence of the key (and its corresponding value) in
     * this list (when traversing the list from head to tail). If the list does
     * not contain the key, it is unchanged.
     * 
     * @param key
     *            the key that needs to be removed, if present
     * @return true if the list contained the specified element
     */
    public boolean removeLast(K key);

    /**
     * Returns true if this list contains the specified key.
     * 
     * @param key
     *            key whose presence in this list is to be tested
     * @return true if this list contains the specified key
     */
    public boolean contains(K key);

    /*
     * (non-Javadoc)
     * 
     * @see cybersecurity.KVStore#get(java.lang.Object)
     */
    @Override
    default public V get(K key) {
        return getFirst(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see cybersecurity.KVStore#put(java.lang.Object, java.lang.Object)
     */
    @Override
    default public void put(K key, V value) {
        addLast(key, value);
    }
}
