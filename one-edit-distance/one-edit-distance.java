class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        
        if (Math.abs(sLen - tLen) > 1)
            return false;
        
        int i = 0, j = 0, diffcount = 0;
        
        
        if (sLen == tLen) {
            while (i < sLen) {
                if (s.charAt(i) != t.charAt(j))
                    diffcount++;
                i++; j++;
            } 
            if (diffcount != 1)
                return false;
            
        } else if (sLen < tLen) {
            while (i < sLen) {
                if (s.charAt(i) != t.charAt(j)) {
                    diffcount++;
                    if (diffcount > 1)
                        return false;
                    j++;
                } else {
                    i++; j++;
                }
            } 
        } else {
            while (j < tLen) {
                if (s.charAt(i) != t.charAt(j)) {
                    diffcount++;
                    if (diffcount > 1)
                        return false;
                    i++;
                } else {
                    i++; j++;
                }
            } 
        }
        return true;
    }
    
    /* 
        
        asgddddl
        atgddddl
        
        if len same, diff of exactly 1 char
        
        lenS < lenT
            go upto unmatched and then insert
            
        lenS > lenT
        deletion
        len should have diff 1
            go upto unmatched and then delete
    
    */
}