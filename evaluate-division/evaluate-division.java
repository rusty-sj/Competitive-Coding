class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];
        
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        
        int i = 0;
        for (List<String> query: queries) {
            String x = query.get(0), y = query.get(1);
            
            answer[i++] = dfs(graph, new HashSet<>(), x, y);
        }
        return answer;
    }
    
    public double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String x, String y) {
        if (!graph.containsKey(x) || !graph.containsKey(y)) 
            return -1.0;

        if (graph.get(x).containsKey(y)) 
            return graph.get(x).get(y);

        visited.add(x);
        for (Map.Entry<String, Double> neighbor : graph.get(x).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double product = dfs(graph, visited, neighbor.getKey(), y);
                if (product != -1.0)
                    return neighbor.getValue() * product;
            }
        }

        return -1.0;
    }
    
    
    public Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        int i = 0;
        for (List<String> variables: equations) {
            String x = variables.get(0), y = variables.get(1);
            
            // x--weight-->y
            if (!graph.containsKey(x))
                graph.put(x, new HashMap<String, Double>());
            graph.get(x).put(y, values[i]);
            
            // y--weight-->x
            if (!graph.containsKey(y))
                graph.put(y, new HashMap<String, Double>());
            graph.get(y).put(x, (1 / values[i]));
            
            // x--1.0-->x self loop
            graph.get(x).put(x, 1.0);
            
            i++;
        }
        
        return graph;
    }
}