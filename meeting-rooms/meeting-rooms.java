class Solution {
    // TC: O(N log N)
    // SC: O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        // Handle empty input
        if (intervals == null || intervals.length == 0)
            return true;
        
        // Sort intervals
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // If overlap, can't attend meetings, return false
            if (intervals[i][0] < end) {
                return false;
            } else {
                end = intervals[i][1];
            }
        }
        return true;
    }
}