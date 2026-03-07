import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>(); // decreasing order
        Deque<Integer> minDeque = new LinkedList<>(); // increasing order
        
        int left = 0, result = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Maintain decreasing order in maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            
            // Maintain increasing order in minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            
            // Check validity: max - min <= limit
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                // Shrink window from left
                left++;
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
            }
            
            // Update result
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}