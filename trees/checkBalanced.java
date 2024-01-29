// Problem Link: https://leetcode.com/problems/balanced-binary-tree/
// Explanation: https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/
// Recurrence relation to use is: 1+max(left.rootheight, right.rootheight)
// balanced formula: height(left root) - height(right root){of a binary tree} <= 1 then it is balanced otherwise it is not

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lh = dfsHeight(root.left);
        if (lh == -1)
            return -1;
        int rh = dfsHeight(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
}