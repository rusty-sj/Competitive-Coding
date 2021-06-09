class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> output = new ArrayList<>();
        
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) 
            return output;
        
        // MinHeap on sum of two integers
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        // add initial pairs all in num1 with num2's 0th index
        for(int i = 0; i < nums1.length && i < k; i++) 
            queue.add(new int[] {nums1[i], nums2[0], 0});
        
        while(!queue.isEmpty() && k-- > 0) {
            int[] top = queue.poll();
            output.add(List.of (top[0], top[1]));
            if (top[2] + 1 < nums2.length) {
                queue.offer (new int[] {top[0], nums2[top[2] + 1], top[2] + 1});
            }
        }
        return output;
    }
}