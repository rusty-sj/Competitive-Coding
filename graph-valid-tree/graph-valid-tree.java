class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            adjList.add(new LinkedList<>());
        
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        
        dfs(0, adjList, visited);
        
        return visited.size() == n;
    }
    
    public void dfs(int node, List<List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(node))
            return;
        visited.add(node);
        for (int neighbor: adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}