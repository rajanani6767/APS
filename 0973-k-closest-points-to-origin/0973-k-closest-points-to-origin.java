import java.util.*;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max heap based on distance
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        for (int[] p : points) {
            heap.offer(p);
            if (heap.size() > k) {
                heap.poll(); // remove farthest
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
