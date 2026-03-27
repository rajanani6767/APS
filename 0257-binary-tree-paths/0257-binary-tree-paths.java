class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        // Add the current node's value to the path string
        path += Integer.toString(node.val);

        // If it's a leaf, add the path to the result list
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            // If not a leaf, add "->" and recurse to children
            if (node.left != null) dfs(node.left, path + "->", paths);
            if (node.right != null) dfs(node.right, path + "->", paths);
        }
    }
}


