class Solution {
    
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            adjList.put(i, new HashSet<Integer>());
        }
        
        for (int[] edge: edges) {
            int vertex1 = edge[0], vertex2 = edge[1];
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(i);
                count++;
                while (!queue.isEmpty()) {
                    int polled = queue.poll();
                    Set<Integer> set = adjList.get(polled);
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        int next = (int) iterator.next();
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }   
            }
        }
        
        return count;
    }
}