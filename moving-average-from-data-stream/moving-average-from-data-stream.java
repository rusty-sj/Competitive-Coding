class MovingAverage {

    private Queue<Integer> queue;
    private int size;
    private double sum;
    
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if (this.queue.size() == this.size) {
            int polled = this.queue.poll();
            this.sum -= polled;
        }
        this.queue.offer(val);
        this.sum += val;
        return this.sum / this.queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */