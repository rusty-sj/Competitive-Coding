class Solution {
    
    /*
    
    1 1 0 0 0 0

    1 1 0 0 0 0

    0 0 1 1 1 0

    0 0 1 1 0 0

    0 0 1 0 1 0

    0 0 0 0 0 1
    
    visited = [t, t, f, f, f, f]
    count = 0
    
    */
    
    public int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0)
            return 0;
        
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, boolean[] visited, int row) {
        for (int col = 0; col < isConnected.length; col++) {
            if (isConnected[row][col] == 1 && visited[col] == false) {
                visited[col] = true;
                dfs(isConnected, visited, col);
            }
        }
    }
}