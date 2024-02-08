// Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// Explanation: https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/
// Hint: Do a traversal by anti-clockwise or clockwise as per the problem and if leafs then add them.
// For Anti clockwise do left traversal then leaves and then right traversal and then rotate the right traversal.
// TC: O(n), SC: O(n)

public class Solution {
    static boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    static void addLeftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode node = root.left;
        while (node != null) {
            if (isLeaf(node) == false)
                ans.add(node.data);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    static void addRightBoundary(TreeNode root, List<Integer> ans) {
        TreeNode node = root.right;
        ArrayList<Integer> ds = new ArrayList<>();
        while (node != null) {
            if (isLeaf(node) == false)
                ds.add(node.data);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        for (int i = ds.size() - 1; i >= 0; i--)
            ans.add(ds.get(i));
    }

    static void addLeaves(TreeNode root, List<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if (root.left != null)
            addLeaves(root.left, ans);
        if (root.right != null)
            addLeaves(root.right, ans);
        ;
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        if (isLeaf(root) == false)
            ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }
}