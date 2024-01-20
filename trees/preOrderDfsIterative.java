// Explanation: https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=10
// Leetcode Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if (root == null)
            return ans;
        stk.push(root);
        while (!stk.isEmpty()) {
            root = stk.pop();
            ans.add(root.val);
            if (root.right != null) {
                stk.push(root.right);
            }
            if (root.left != null) {
                stk.push(root.left);
            }
        }
        return ans;
    }
}