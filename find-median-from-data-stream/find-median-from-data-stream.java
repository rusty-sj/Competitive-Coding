class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        this.minHeap = new PriorityQueue<>((a, b) -> a.compareTo(b));
    }
    
    public void addNum(int num) {
        this.maxHeap.offer(num);
        this.minHeap.offer(maxHeap.poll());
        if (this.maxHeap.size() < this.minHeap.size())
		    this.maxHeap.offer(this.minHeap.poll());
    }
    
    public double findMedian() {
        if (this.maxHeap.size() == this.minHeap.size())
		    return (this.maxHeap.peek() + this.minHeap.peek()) / 2.0;
	    else
		    return this.maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */