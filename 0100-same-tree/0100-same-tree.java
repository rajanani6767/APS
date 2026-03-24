class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, the trees are identical at this position
        if (p == null && q == null) {
            return true;
        }
        
        // If one is null or values don't match, they aren't the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
