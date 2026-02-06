import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        int n = s.length();
        boolean[] remove = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Identify invalid parentheses
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } 
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    remove[i] = true; // invalid ')'
                } else {
                    stack.pop(); // matched
                }
            }
        }

        // Step 2: Remaining '(' are invalid
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Step 3: Build result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
