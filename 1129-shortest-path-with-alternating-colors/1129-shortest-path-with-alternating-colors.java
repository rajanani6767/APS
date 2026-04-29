import java.util.*;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Build adjacency lists
        List<List<Integer>> redGraph = new ArrayList<>();
        List<List<Integer>> blueGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            redGraph.add(new ArrayList<>());
            blueGraph.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            redGraph.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueGraph.get(edge[0]).add(edge[1]);
        }

        // Result array
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // BFS queue: [node, color], color: 0 = red, 1 = blue
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];

        // Start from node 0 with both colors
        queue.offer(new int[]{0, 0}); // red
        queue.offer(new int[]{0, 1}); // blue
        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0], color = cur[1];

                if (result[node] == -1) {
                    result[node] = steps;
                }

                // Next edges must alternate color
                List<Integer> nextNodes = (color == 0) ? blueGraph.get(node) : redGraph.get(node);
                int nextColor = 1 - color;

                for (int nei : nextNodes) {
                    if (!visited[nei][nextColor]) {
                        visited[nei][nextColor] = true;
                        queue.offer(new int[]{nei, nextColor});
                    }
                }
            }
            steps++;
        }

        return result;
    }
}
