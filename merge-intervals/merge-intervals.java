class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int1, int2) -> 
                    int1[0] == int2[0] ? int1[1] - int2[1] : int1[0] - int2[0]);
        
        List<int[]> output = new ArrayList<>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                output.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        output.add(new int[]{start, end});
        return output.toArray(new int[output.size()][2]);
    }
}