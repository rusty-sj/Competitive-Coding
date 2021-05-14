class MedianFinder {

    PriorityQueue<Integer> leftHeap, rightHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (this.leftHeap.isEmpty() || this.leftHeap.peek() > num) {
            this.leftHeap.add(num);
        } else {
            this.rightHeap.add(num);
        }
        if (this.leftHeap.size() < this.rightHeap.size()) {
            this.leftHeap.add(this.rightHeap.poll());
        } else if (this.rightHeap.size() < this.leftHeap.size() - 1) {
            this.rightHeap.add(this.leftHeap.poll());
        }
    }
    
    public double findMedian() {
        if ((this.leftHeap.size() + this.rightHeap.size()) % 2 == 0) {
            return (double) (this.leftHeap.peek() + this.rightHeap.peek()) / 2;
        } else
            return (double) this.leftHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

    