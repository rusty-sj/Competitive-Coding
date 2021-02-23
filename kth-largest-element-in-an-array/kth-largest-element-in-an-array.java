class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min heap
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((a, b) -> a - b);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }
        return heap.poll();   
    }
}