class Solution {
    public boolean isSymmetric(TreeNode root) {
        // A null tree is symmetric
        if (root == null) return true;
        // Check if the left and right subtrees are mirrors of each other
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both empty = symmetric
        if (t1 == null && t2 == null) return true;
        // One empty or values differ = not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) return false;
        
        // Mirror check: 
        // 1. Left of t1 with Right of t2
        // 2. Right of t1 with Left of t2
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
