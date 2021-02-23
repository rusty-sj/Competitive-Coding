class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        
        for (String word : products)
            trie.insert(word);
        
        TrieNode node = trie.root;
        
        List<List<String>> output = new ArrayList<>();
        
        for(char c : searchWord.toCharArray()) {
            List<String> l = new ArrayList<String>();
            if (node == null) {
                output.add(l);
            } else {
                node = node.children[c - 'a'];
                find(node, l);
                output.add(l);
            }
        }
        return output;
    }
    
    public void find(TrieNode node, List<String> matched) {
        if (node == null)
            return;
        if (node.isWord) {
            if (matched.size() < 3)
                matched.add(node.word);
            else 
                return;
        }
        for (TrieNode n : node.children)
            find(n, matched);
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    String word;
    
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
        this.word = "";
    }
}

class Trie {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
        node.word = word;
    }
}