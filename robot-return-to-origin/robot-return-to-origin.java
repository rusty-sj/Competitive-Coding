class Solution {
    
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)
            return true;
        
        int ucount = 0, dcount = 0, lcount = 0, rcount = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L')
                lcount++;
            else if (c == 'R')
                rcount++;
            else if (c == 'U')
                ucount++;
            else
                dcount++;
        }
        return rcount == lcount && ucount == dcount;
    }
}