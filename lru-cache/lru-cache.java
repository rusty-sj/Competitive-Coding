class DLLNode {
    int key;
    int value;
    DLLNode prev = null;
    DLLNode next = null;
    
    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, DLLNode> cache;
    DLLNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DLLNode(-1, -1);
        this.tail = new DLLNode(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        int returnVal = -1;
        DLLNode node = this.cache.getOrDefault(key, null);
        if (node != null) {
            returnVal = node.value;
            remove(node);
            addFront(node);
        }
        return returnVal;
    }
    
    public void put(int key, int value) {
        DLLNode node = this.cache.getOrDefault(key, null);
        if (node == null) {
            node = new DLLNode(key, value);
            if (this.cache.size() == this.capacity) {
                DLLNode last = this.tail.prev;
                this.cache.remove(last.key);
                remove(last);
            }
        } else {
            node.value = value;
            remove(node);
        }
        addFront(node);
        this.cache.put(key, node);
    }
    
    /* Doubly Linked List utils */
    
    // Remove a node from the linked list
    public void remove(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Add given node to the beginning of the linked list
    public void addFront(DLLNode node) {
        DLLNode headNext = this.head.next;
        this.head.next = node;
        node.next = headNext;
        node.prev = this.head;
        node.next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */