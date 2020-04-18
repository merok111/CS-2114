package cybersecurity;

/**
 * KVSTORE interface
 * 
 * @author victoriahairston1
 * @version 28.3.17
 * @param <K>
 *            the type for the key
 * @param <V>
 *            the type for the value
 */
public interface KVStore<K, V> {
    /**
     * Returns the value to which the specified key is mapped, or null if this
     * store contains no mapping for the key.
     * 
     * @param key
     *            the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this
     *         map contains no mapping for the key
     */
    public V get(K key);

    /**
     * Maps the specified key to the specified value in this store.
     * 
     * @param key
     *            the key
     * @param value
     *            the value to which the key will be mapped
     */
    public void put(K key, V value);
}
