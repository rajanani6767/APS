import java.util.*;

class Solution {
    // Helper class to store node information
    class NodeInfo {
        int row;
        int col;
        int val;

        NodeInfo(int r, int c, int v) {
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodeList = new ArrayList<>();
        dfs(root, 0, 0, nodeList);

        // Sort based on: 1. Column, 2. Row, 3. Value
        Collections.sort(nodeList, (a, b) -> {
            if (a.col != b.col) return Integer.compare(a.col, b.col);
            if (a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });

        List<List<Integer>> result = new ArrayList<>();
        if (nodeList.isEmpty()) return result;

        // Group the sorted nodes by column
        int lastCol = nodeList.get(0).col;
        List<Integer> currentColumn = new ArrayList<>();

        for (NodeInfo node : nodeList) {
            if (node.col == lastCol) {
                currentColumn.add(node.val);
            } else {
                result.add(currentColumn);
                currentColumn = new ArrayList<>();
                currentColumn.add(node.val);
                lastCol = node.col;
            }
        }
        result.add(currentColumn); // Add the final column group

        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<NodeInfo> list) {
        if (node == null) return;
        list.add(new NodeInfo(row, col, node.val));
        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}
