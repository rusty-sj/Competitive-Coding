class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] != '1')
            return;
        grid[i][j] = '#';
        int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        for (int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < grid.length
               && c >=0 && c < grid[i].length
               && grid[r][c] == '1')
                dfs(grid, r, c);
        }
            
    }
}