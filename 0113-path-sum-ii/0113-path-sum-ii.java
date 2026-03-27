class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        // 1. Add current node to path
        currentPath.add(node.val);

        // 2. Check if it's a leaf and sum matches
        if (node.left == null && node.right == null && remainingSum == node.val) {
            // Must create a NEW list because currentPath is modified later
            result.add(new ArrayList<>(currentPath));
        } else {
            // 3. Recurse left and right
            findPaths(node.left, remainingSum - node.val, currentPath, result);
            findPaths(node.right, remainingSum - node.val, currentPath, result);
        }

        // 4. Backtrack: remove the current node before going back up the tree
        currentPath.remove(currentPath.size() - 1);
    }
}

