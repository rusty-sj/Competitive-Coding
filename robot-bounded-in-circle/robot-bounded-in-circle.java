class Solution {
    public boolean isRobotBounded(String instructions) {
        
        // Directions in sequence N, E, S, W
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        // Start at position (0, 0) and direction dirs[0]/North
        int coordinateX = 0;
        int coordinateY = 0;
        int direction = 0; // Ranges 0-3
        
        for (char c: instructions.toCharArray()) {
            if (c == 'G') {
                coordinateX += dirs[direction][0];
                coordinateY += dirs[direction][1];
            } else if (c == 'L') {
                direction = (direction + 3) % 4;
            } else if (c == 'R') {
                direction = (direction + 1) % 4;
            }
        }
        
        // If we end up at start position (0, 0) or we end up in a direction other than start direction (N), there is a circle
        if ((coordinateX == 0 && coordinateY == 0) || direction != 0)
            return true;
        
        return false;
    }
}