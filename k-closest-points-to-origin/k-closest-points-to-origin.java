class Solution {
    
    class Point {
        int x, y;
        double eucl;
        
        public Point(int x, int y, double eucl) {
            this.x = x;
            this.y = y;
            this.eucl = eucl;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0)
            return new int[0][0];
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> Double.compare(a.eucl, b.eucl));
        for (int[] point: points) {
            int x = point[0], y = point[1];
            double eucl = Math.sqrt(x * x + y * y);
            pq.add(new Point(x, y, eucl));
        }
        
        int[][] output = new int[k][2];
        
        int i = 0;
        while (!pq.isEmpty() && i < k) {
            Point point = pq.poll();
            output[i][0] = point.x;
            output[i][1] = point.y;
            i++;
        }
        return output;
    }
}