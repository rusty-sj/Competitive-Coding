/**
 * Create an array of Buckets with a restricted size and all the values are processed through modulus function
 * A Bucket has a LinkedList of type HashKey
 */

// Time Complexity
// Average: O(N/K), Worst case O(N); N: number of keys; K: number of buckets

// Space Complexity
// O(M + K); M: number of unique values in set; K: number of buckets

import java.util.LinkedList;
import java.util.List;

/**
 * Unique value in a hashSet
 *
 * @param <V> value
 */
class HashKey<V> {
    public V value;

    public HashKey(V value) {
        this.value = value;
    }
}

/**
 * Each Bucket pointing to a LinkedList of Integers
 */
class Bucket {
    List<HashKey<Integer>> buckets;

    Bucket() {
        this.buckets = new LinkedList<>();
    }

    public boolean contains(int key) {
        for (HashKey<Integer> hashKey : this.buckets)
            if (hashKey.value.equals(key))
                return true;
        return false;
    }

    public void insert(int key) {
        boolean exists = false;
        for (HashKey<Integer> hashKey : this.buckets)
            if (hashKey.value.equals(key)) {
                exists = true;
                break;
            }
        if (!exists) {
            this.buckets.add(new HashKey<Integer>(key));
        }
    }

    public void remove(int key) {
        for (HashKey<Integer> hashKey : this.buckets)
            if (hashKey.value.equals(key)) {
                this.buckets.remove(hashKey);
                break;
            }
    }
}

class MyHashSet_LC705 {
    private Bucket[] hashSet;
    private int keySize;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet_LC705() {
        this.keySize = 2999;
        this.hashSet = new Bucket[this.keySize];
        for (int i = 0; i < this.keySize; i++)
            hashSet[i] = new Bucket();
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = key % this.keySize;
        return this.hashSet[hash].contains(key);
    }

    public void add(int key) {
        int hash = key % this.keySize;
        this.hashSet[hash].insert(key);
    }

    public void remove(int key) {
        int hash = key % this.keySize;
        this.hashSet[hash].remove(key);
    }
}