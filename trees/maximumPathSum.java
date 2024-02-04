// Problem Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Explanation: https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
// Recurrence relation to use is: (node.val)+max(left.rootheight, right.rootheight)

class Solution {
    public int maxPathSum(TreeNode root) {
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxi);
        return maxi[0];
    }

    public int maxPathDown(TreeNode root, int maxi[]) {
        if (root == null)
            return 0;
        int leftSum = Math.max(0, maxPathDown(root.left, maxi));
        int rightSum = Math.max(0, maxPathDown(root.right, maxi));
        maxi[0] = Math.max(maxi[0], leftSum + rightSum + root.val);
        return (root.val) + Math.max(leftSum, rightSum);
    }
}