class Message {
    String message;
    int timestamp;
    
    public Message(String message, int timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}

class Logger {

    Queue<Message> queue;
    Set<String> set;
    
    /** Initialize your data structure here. */
    public Logger() {
        this.queue = new LinkedList<>();
        this.set = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!this.queue.isEmpty() && this.queue.peek().timestamp <= timestamp - 10) {
            Message toPoll = this.queue.poll();
            this.set.remove(toPoll.message);
        }
        if (this.set.contains(message))
            return false;
        else {
            this.queue.add(new Message(message, timestamp));
            this.set.add(message);
        }
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */