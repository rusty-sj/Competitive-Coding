class Solution {
    public int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    Map<Character, Integer> map = new HashMap<>(){ 
        {put('L', 0);
        put('R', 1);
        put('U', 2);
        put('D', 3);}};
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)
            return true;
        int coordinateX = 0, coordinateY = 0;
        for (char c: moves.toCharArray()) {
            int move = map.get(c);
            coordinateX += dirs[move][0];
            coordinateY += dirs[move][1];
        }
        return coordinateX == 0 && coordinateY ==0;
    }
}