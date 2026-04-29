import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        // Min-heap storing (sum, i, j)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        // Initialize heap with first k pairs (nums1[i], nums2[0])
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract k smallest pairs
        while (k > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            int i = cur[1], j = cur[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Push next pair (nums1[i], nums2[j+1]) if available
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            k--;
        }

        return result;
    }
}
