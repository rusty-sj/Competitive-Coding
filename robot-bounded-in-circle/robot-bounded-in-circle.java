class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int anchor = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            if (instruction == 'G') {
                x += dirs[anchor][0];
                y += dirs[anchor][1];
            } else if (instruction == 'L') {
                anchor = (anchor + 3) % 4;
            } else if (instruction == 'R') {
                anchor = (anchor + 1) % 4;
            }
        }
        return (x == 0 && y == 0) || (anchor != 0);
    }
}