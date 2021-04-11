class DSU {
    int[] parents;
    
    public DSU(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
    }
    
    public int findParent(int i) {
        if (parents[i] != i) 
            parents[i] = findParent(parents[i]);
        return parents[i];
    }
    
    public void parentPrinter() {
        for (int i = 0; i < parents.length; i++) System.out.print(parents[i] + " ");
    }
    
    public boolean union(int i, int j) {
        int parent1 = findParent(i), parent2 = findParent(j);
        if (parent1 == parent2)
            return false;
        parents[parent1] = parent2;
        return true;
    }
}

class Solution {
    
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        DSU dsu = new DSU(m * n);
        int components = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    components++;
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row >= 0 && row < m &&
                           col >= 0 && col < n && grid[row][col] == '1')
                            if (dsu.union(i * n + j, row * n + col))
                                components--;
                    }
                } 
            }
        }
        dsu.parentPrinter();
        return components;
    }
}

/*
(0,0) (0,1) (0,2)
0       1       2
(1,0) (1,1) (1,2)
3       4       5
(2,0) (2,1) (2,2)
6       7       8
*/