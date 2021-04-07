class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        // Form vocab data structure as per order given
        int[] vocab = new int[26];
        int x = 0;
        for (char ch: order.toCharArray()) 
            vocab[ch - 'a'] = x++;
        
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                
                // word[i] longer than next word
                if (j >= words[i + 1].length()) 
                    return false;
                
                char ch1 = words[i].charAt(j);
                char ch2 = words[i + 1].charAt(j);
                if (ch1 != ch2) {
                    if (vocab[ch1 - 'a'] > vocab[ch2 - 'a'])
                        return false;
                    else 
                        break;
                }
            }
        }
        return true;
    }
}