package QueenStack;

import java.util.LinkedHashMap;

/**
 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 Implement the LRUCache class:
 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 int get(int key) Return the value of the key if the key exists, otherwise return -1.
 void put(int key, int value) Update the value of the key if the key exists. Otherwise,
 add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 evict the least recently used key.
 The functions get and put must each run in O(1) average time complexity.
 */
public class LRU_Cache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRU_Cache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsValue(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    private void makeRecently(int key) {
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public void put(int key, int val) {
        if (cache.containsValue(key)){
            cache.put(key, val);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap){
            Integer oldesrKey = cache.keySet().iterator().next();
            cache.remove(oldesrKey);
        }
        cache.put(key, val);
    }
}
