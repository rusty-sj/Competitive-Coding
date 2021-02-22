class LRUCache {

    int capacity;
    Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        int value = this.map.getOrDefault(key, -1);
        if (value != -1) {
            this.map.remove(key);
            this.map.put(key, value);
        }
        return value;
    }
    
    public void put(int key, int value) {
        int val = this.map.getOrDefault(key, -1);
        if (val == -1) {
            if (this.map.size() == this.capacity) {
                this.map.remove(this.map.keySet().iterator().next());
            }
        } else
            this.map.remove(key);
        this.map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */