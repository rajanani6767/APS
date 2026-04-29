import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap of size k
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll(); // remove smallest
            }
        }
        
        return heap.peek(); // root of heap is kth largest
    }
}
