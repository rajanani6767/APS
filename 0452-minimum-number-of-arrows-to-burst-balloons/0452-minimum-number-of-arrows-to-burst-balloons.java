import java.util.*;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;          // need a new arrow
                end = points[i][1]; // update end
            }
            // else: current balloon is already burst by the arrow at 'end'
        }

        return arrows;
    }
}
