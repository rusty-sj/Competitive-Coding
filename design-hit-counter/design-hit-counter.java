class HitCounter {
    
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        this.queue.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!this.queue.isEmpty() && this.queue.peek() <= timestamp - 300) 
            this.queue.poll();
        return this.queue.size();
    }
    
    // 1 1 1 1 ..........10000 (1)
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */