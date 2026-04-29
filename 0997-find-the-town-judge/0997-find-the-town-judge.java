public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        // Count trust relationships
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            outDegree[a]++;
            inDegree[b]++;
        }

        // Judge must have in-degree = n-1 and out-degree = 0
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
