import java.util.*;

public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize distances
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                } else {
                    dist[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        // Step 2: BFS from all zeros
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist;
    }
}
