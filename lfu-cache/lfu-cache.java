class LFUCache {
    
    int capacity;
    Map<Integer, Entry> entries;
    TreeSet<Entry> treeSet;
    int seqCounter;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.entries = new HashMap<>();
        this.treeSet = new TreeSet<>();
        this.seqCounter = 0;
    }
    
    public int get(int key) {
        if (entries.containsKey(key)) {
            Entry entry = entries.get(key);
            entries.remove(entry);
            this.treeSet.remove(entry);
            Entry newEntry = new Entry(key, entry.val, entry.freq + 1, this.seqCounter++);
            this.entries.put(key, newEntry);
            this.treeSet.add(newEntry);
            return entry.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.capacity <= 0)
            return;
        Entry newEntry;
        if (entries.containsKey(key)) {
            Entry entry = entries.get(key);
            this.entries.remove(entry);
            this.treeSet.remove(entry);
            newEntry = new Entry(key, value, entry.freq + 1, this.seqCounter++);
        } else {
            if (this.treeSet.size() == this.capacity) {
                Entry first = this.treeSet.pollFirst();
                this.entries.remove(first.key);
            }
            newEntry = new Entry(key, value, 1, this.seqCounter++);
        }
        this.entries.put(key, newEntry);
        this.treeSet.add(newEntry);
    } 
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Entry implements Comparable<Entry> {
    int key;
    int val;
    int freq;
    int seq;
    
    public Entry(int key, int val, int freq, int seq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.seq = seq;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entry)) 
            return false;
        return this.key == ((Entry) o).key;
    }
    
    @Override
    public int hashCode() {
        return key;
    }
    
    @Override
    public int compareTo(Entry e) {
        return this.freq == e.freq ? this.seq - e.seq : this.freq - e.freq;
    }
}