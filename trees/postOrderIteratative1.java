// Using 2 Stack
// Explanation: https://youtu.be/2YBhNLodD8Q?si=pYUDme-YL1AfSj5J
// Leetcode: https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        if (root == null)
            return ans;
        stk1.push(root);
        while (!stk1.isEmpty()) {
            root = stk1.pop();
            stk2.push(root);
            if (root.left != null)
                stk1.push(root.left);
            if (root.right != null)
                stk1.push(root.right);
        }
        while (!stk2.isEmpty()) {
            ans.add(stk2.pop().val);
        }
        return ans;
    }
}