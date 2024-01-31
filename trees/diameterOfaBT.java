// Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
// Explanation: https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/
// Recurrence relation to use is: 1+max(left.rootheight, right.rootheight), same as maximum height of a binary tree.
// diameter of a binary tree is the longest path to a node and the path need not pass through the root.
// TC -> O(n), SC -> O(n) {auxilliary space}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int res[] = new int[1];
        res[0] = 0;
        height(root, res);
        return res[0];
    }

    public int height(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        int leftH = height(root.left, res);
        int rightH = height(root.right, res);
        res[0] = Math.max(res[0], leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}