class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Set<Character> hSet = new HashSet<>();
        // Set<Character> vSet = new HashSet<>();
        // Set<Character> boxSet = new HashSet<>();
        
        for (int i = 0; i < board.length; i++) {
            Set<Character> hSet = new HashSet<>();
            Set<Character> vSet = new HashSet<>();
            Set<Character> boxSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char c1 = board[i][j], c2 = board[j][i], c3 = board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)];
                if (c1 != '.')
                    if (hSet.contains(c1))
                        return false;
                    hSet.add(board[i][j]);
                
                if (c2 != '.')
                    if (vSet.contains(c2))
                        return false;
                    vSet.add(c2);
                
                if (c3 != '.')
                    if (boxSet.contains(c3))
                        return false;
                    boxSet.add(c3);
                
            }   
        }
        return true;
    }
}