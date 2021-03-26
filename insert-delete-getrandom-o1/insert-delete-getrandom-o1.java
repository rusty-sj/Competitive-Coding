class RandomizedSet {
    
    Map<Integer, Integer> mappings;
    LinkedList<Integer> set; 
    int size;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.mappings = new HashMap<>();
        this.set = new LinkedList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (this.mappings.containsKey(val))
            return false;
        
        // Add val to list and update its index in hashmap
        this.set.add(val);
        this.mappings.put(val, this.set.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (this.mappings.containsKey(val)) {
            // To remove in O(1) from LinkedList, swap element at index with last index element and then remove last from linked list
            int index = this.mappings.get(val);
            Collections.swap(this.set, index, this.set.size() - 1);
            
            // Update mapping for the last element which was swapped
            this.mappings.put(this.set.get(index), index);
            
            this.set.removeLast();
            // Remove val from mappings
            this.mappings.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // Generate a random index in range of size of LinkedList and return the element at that index
        Random random = new Random();
        int randIndex = random.nextInt(this.set.size());
        return this.set.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */