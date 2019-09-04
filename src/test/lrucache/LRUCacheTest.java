package test.lrucache;

import main.lrucache.LRUCache;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
public class LRUCacheTest {

    @Test
    public void receiveWhenEmpty() {
        LRUCache<Integer, String> cache = new LRUCache<>(1);
        assertNull(cache.get(0));
    }

    @Test
    public void receiveWhenOtherPresent() {
        LRUCache<Integer, String> cache = new LRUCache<>(1);
        cache.set(0, "hello");

        assertNull(cache.get(1));
        assertEquals("hello", cache.get(0));
    }

    @Test
    public void overwriteKey() {
        LRUCache<Integer, String> cache = new LRUCache<>(10);

        cache.set(0, "hello");
        cache.set(0, "world");

        assertEquals("world", cache.get(0));
    }

    @Test
    public void overwriteLRUKeyWhenFullSizeOne() {
        LRUCache<Integer, String> cache = new LRUCache<>(1);

        cache.set(0, "hello");
        cache.set(1, "world");

        assertNull(cache.get(0));
        assertEquals("world", cache.get(1));
    }

    @Test
    public void overwriteLRUKeyWhenFullSizeTwo() {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.set(0, "hello");
        cache.set(1, "world");
        cache.set(2, "how");

        assertNull(cache.get(0));
        assertEquals("world", cache.get(1));
        assertEquals("how", cache.get(2));

        // increase usages of second last added key
        cache.get(1);
        // key 2 holds LRU despite being most recently added so should be overwritten
        cache.set(4, "woah");
        assertNull(cache.get(2));
        assertEquals("world", cache.get(1));
        assertEquals("woah", cache.get(4));
    }
}