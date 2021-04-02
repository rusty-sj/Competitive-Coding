class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int popCount = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minHeap.add(matrix[i][j]);
            }
        }
        while (popCount++ < k - 1) 
            minHeap.poll();
        return minHeap.poll();
    }
}