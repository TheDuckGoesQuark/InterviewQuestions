package interview.lrucache;

import java.util.LinkedHashMap;

/**
 * Implement an LRU (Least Recently Used) cache.
 * <p>
 * It should be able to be initialized with a cache size n, and contain the following methods:
 * <p>
 * set(key, value): sets key to value.
 * If there are already n items in the cache and we are adding a new item,
 * then it should also remove the least recently used item.
 * <p>
 * get(key): gets the value at key.
 * If no such key exists, return null.
 * <p>
 * Each operation should run in O(1) time.
 */
public class LRUCache<K, V> {

    private final LinkedHashMap<K, V> map;

    private final int size;

    public LRUCache(int size) {
        this.size = size;
        this.map = new LinkedHashMap<>();
    }

    public void set(K key, V value) {
        if (map.size() == size)
            removeLRU();

        setOrOverwriteKey(key, value);
    }

    private void setOrOverwriteKey(K key, V value) {
        // if key exists, remove old entry
        map.remove(key);
        map.put(key, value);
    }

    private void removeLRU() {
        K lruKey = map.keySet().iterator().next();
        map.remove(lruKey);
    }

    public V get(K key) {
        final V value = map.getOrDefault(key, null);

        if (value != null) {
            map.remove(key);
            map.put(key, value);
        }

        return value;
    }
}
