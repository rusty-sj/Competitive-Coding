class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) 
            dfs(image, sr, sc, color, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            for (int[] dir : dirs) {
                int x = dir[0] + r;
                int y = dir[1] + c;
                
                if (x >= 0 && x < image.length
                   && y >= 0 && y < image[r].length)
                    dfs(image, x, y, color, newColor);
            }
        }
    }
}