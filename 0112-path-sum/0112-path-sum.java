class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. If tree is empty, no path exists
        if (root == null) return false;

        // 2. Subtract current value from target
        targetSum -= root.val;

        // 3. Check if it's a leaf node and if sum is met
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // 4. Otherwise, recurse left and right
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
