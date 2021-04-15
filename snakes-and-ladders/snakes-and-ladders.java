class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        Queue<Integer> queue = new LinkedList<>();  // Queue for BFS
        Set<Integer> visited = new HashSet<>();     // Visited set
        queue.add(1);
        visited.add(1);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            // Explore each level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int position = queue.poll();
                if (position == n * n)
                    return steps;
                
                // Explore 6 dice choices
                for (int choice = 1; choice <= 6 && position + choice <= n * n; choice++) {
                    int action = position + choice;
                    int r = n - 1 - (action - 1) / n;
                    int c = (action - 1) % n;
                    c = (r % 2 == n % 2) ? n - 1 - c : c;
                    int nextPos = board[r][c] == -1 ? action : board[r][c];
                    if (!visited.contains(nextPos)) {
                        queue.add(nextPos);
                        visited.add(nextPos);
                    } 
                }
            }
            steps++;
        }
        return -1;
    }
    
    public int[] getCoordinate(int n, int rows, int cols) {
        int r = rows - 1 - (n - 1) / cols;
        int c = (n - 1) % cols;
        if (r % 2 == rows % 2) {
            return new int[]{r, cols - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }
}
