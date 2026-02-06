import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        // Copy original prices
        for (int i = 0; i < n; i++) {
            answer[i] = prices[i];
        }

        // Stack to store indices
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Apply discount to previous items
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                answer[idx] = prices[idx] - prices[i];
            }

            // Push current index
            stack.push(i);
        }

        return answer;
    }
}
