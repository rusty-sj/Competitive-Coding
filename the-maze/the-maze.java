class Solution {
    int[][] dirs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        return helper(maze, visited, start, destination, n, m);
    }
    public boolean helper(int[][] maze, boolean[][] visited, int[] start, int[] destination, int n, int m) {
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        visited[start[0]][start[1]] = true;
        
        for (int[] dir: dirs) {
            int r = start[0];
            int c = start[1];
            while (r + dir[0] >= 0 && r + dir[0] < n && (c + dir[1]) >= 0 && (c + dir[1]) < m && maze[r + dir[0]][c + dir[1]] == 0) {
                r += dir[0];
                c += dir[1];
            }
            if (!visited[r][c] && helper(maze, visited, new int[]{r, c}, destination, n, m))
                return true;
        }
        return false;
    }
}