package main.lrucache;

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

    private final int size;

    public LRUCache(int size) {
        this.size = size;
    }

    public void set(K key, V value) {

    }

    public V get(K key) {
        return null;
    }
}
