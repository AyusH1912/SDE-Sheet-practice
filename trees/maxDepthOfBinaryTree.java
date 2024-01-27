// Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Explanation: https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/
// Recurrence relation to use is: 1+max(left.rootheight, right.rootheight)

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lheight = maxDepth(root.left);
        int rheight = maxDepth(root.right);

        return 1 + Math.max(lheight, rheight);
    }
}