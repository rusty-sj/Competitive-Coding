class Solution {
    
    public int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        int nIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    nIslands++;
                }
            }
        }
        return nIslands;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        
        // Mark visited
        grid[i][j] = '#';
        
        // Recursive step
        for (int[] dir: dirs) {
            int row = dir[0] + i;
            int column = dir[1] + j;
            
            if (row >= 0 && row < grid.length
               && column >= 0 && column < grid[i].length 
               && grid[row][column] == '1')
                dfs(grid, row, column);
            
        }
    }
}