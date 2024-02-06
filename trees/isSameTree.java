// Problem Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Explanation: https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
// Hint: Do any DFS traversal on both the trees simultaneously.
// TC: O(n), SC: O(n)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}