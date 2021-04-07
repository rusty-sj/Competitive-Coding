class QNode {
    int val;
    QNode next = null;
    
    public QNode(int val) {
        this.val = val;
    }
}

class MyCircularQueue {

    int capacity;
    QNode head, tail;
    int size;
    
    public MyCircularQueue(int k) {
        this.head = null;
        this.tail = null;
        this.capacity = k;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        QNode node = new QNode(value);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else if (this.isFull()) {
            return false;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.size++;
        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) 
            return false;
        
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        this.size--;
        return true;
    }
    
    public int Front() {
        return this.isEmpty() ? -1 : this.head.val;
    }
    
    public int Rear() {
        return this.isEmpty() ? -1 : this.tail.val;
    }
    
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */