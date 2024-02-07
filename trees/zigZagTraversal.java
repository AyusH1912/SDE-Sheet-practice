// Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Explanation: https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/
// Hint: Do a level order traversal by just adding a flag variable to reverse the list while adding.
// TC: O(n), SC: O(n)

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();
        if (root == null)
            return wrapList;
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> ds = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (flag)
                    ds.add(node.val);
                else
                    ds.add(0, node.val);
            }
            flag = !flag;
            wrapList.add(ds);
        }
        return wrapList;
    }
}