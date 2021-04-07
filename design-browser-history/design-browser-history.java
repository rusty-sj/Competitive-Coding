class URLNode {
    String url;
    URLNode prev = null, next = null;
    
    public URLNode(String url) {
        this.url = url;
    }
}
class BrowserHistory {  
    
    URLNode head;
    
    public BrowserHistory(String homepage) {
        URLNode home = new URLNode(homepage);
        head = home;
    }
    
    public void visit(String url) {
        URLNode node = new URLNode(url);
        head.next = node;
        node.prev = head;
        head = head.next;
    }
    
    public String back(int steps) {
        while (steps-- > 0 && (head != null && head.prev != null)) {
            head = head.prev;
        }
        return head.url;
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && (head != null && head.next != null)) {
            head = head.next;
        }
        return head.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */