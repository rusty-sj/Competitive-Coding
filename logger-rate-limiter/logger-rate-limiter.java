class Logger {

    Map<String, Integer> messageMap;
    
    /** Initialize your data structure here. */
    public Logger() {
        this.messageMap = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (this.messageMap.getOrDefault(message, 0) > timestamp) {
                return false;
        }
        this.messageMap.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */