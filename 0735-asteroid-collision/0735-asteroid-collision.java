import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {

            boolean alive = true;

            // Collision condition
            while (alive && !stack.isEmpty() && stack.peek() > 0 && a < 0) {

                int top = stack.peek();

                if (Math.abs(a) > Math.abs(top)) {
                    // Top asteroid explodes
                    stack.pop();
                } 
                else if (Math.abs(a) == Math.abs(top)) {
                    // Both explode
                    stack.pop();
                    alive = false;
                } 
                else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            // If current asteroid survived
            if (alive) {
                stack.push(a);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
