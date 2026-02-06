class Solution {
    public int[] dailyTemperatures(int[] temperatures) {


        int n = temperatures.length;
        int[] answer = new int[n];

        // Stack to store indices of days
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // While current temperature is warmer than stack top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay;
            }

            // Push current day index
            stack.push(i);
        }

        // Remaining indices automatically have 0
        return answer;
    }
}

        

