package interview;

import java.util.*;

/**
 * Unidirectional Graph Traversal to check Path from Source (Start) to Destination (End).
 */

public class PathExistenceIn2DArray {

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }};
        int start = 0;
        int end = 2;

        boolean pathExists = doesPathExist(edges, start, end);
        System.out.println("Path exists: " + pathExists);
}

    private static boolean doesPathExist(int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        System.out.println(graph);

        Set<Integer> visited = new HashSet<>();
        return dfs(graph, start, end, visited);
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u); // Assuming the graph is undirected
        }
        return graph;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int start, int end, Set<Integer> visited) {
        if (start == end) {
            return true;
        }

        visited.add(start);
        for (int neighbor : graph.getOrDefault(start, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(graph, neighbor, end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

}
