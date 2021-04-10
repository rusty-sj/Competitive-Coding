class Solution {
    
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
    
    public void dfs(int[][] isConnected, boolean[] visited, int node) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && visited[i] == false) {
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
    }
}