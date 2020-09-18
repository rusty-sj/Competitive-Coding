/**
 * Store the value at source point so that we flood fill valid neighbors that have same value as source
 * recursively go in a dfs fashion to change color for all 4 neighbors at any pixel point
 * during recursion, make sure to fill only valid pixels
 *
 * Time Complexity: O(N) N: Number of pixels in image
 * Space Complexity: O(N)
 */
public class FloodFill_LC733 {
    private int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};    // 4-directional pixels
    private int oldColor;                                               // Pixel color of starting pixel

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        if (oldColor != newColor)                                       // If color at coordinates isn't equal to new
            changeColor(image, sr, sc, newColor);                       // Recurse DFS
        return image;
    }

    private void changeColor(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == oldColor) {                                // Flood fill only if pixel color is same as starting pixel
            image[sr][sc] = newColor;
            for (int[] dir : directions) {                              // Explore 4 directions and apply DFS
                int row = dir[0] + sr;
                int column = dir[1] + sc;
                if (row >= 0 && row < image.length
                        && column >= 0 && column < image[0].length)
                    changeColor(image, row, column, newColor);
            }
        }
    }
}
