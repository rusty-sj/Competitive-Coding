class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Empty input
        if (intervals == null || intervals.length == 0)
            return 0;
        
        // Sort on start time then end to avoid cycles
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        // Maintain a min heap of alloted rooms
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int[] interval: intervals) {
            if (!queue.isEmpty() && queue.peek()[1] <= interval[0]) 
                queue.poll();
            queue.add(interval);
        }
        return queue.size();
    }
}