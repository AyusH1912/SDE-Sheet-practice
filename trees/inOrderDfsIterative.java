// Explanation: https://youtu.be/lxTGsVXjwvM?si=oQQoM4ALx-B0olgV
// Leetcode Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if (root == null)
            return ans;
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stk.push(node);
                node = node.left;
            } else {
                if (stk.isEmpty()) {
                    break;
                }
                node = stk.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
}
