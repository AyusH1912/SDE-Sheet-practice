// Recursive Traversal Solution
// Time Complexity: O(n) n = no. of nodes
// Space Complexity: O(n) auxiliary space of nodes

// class Node {
//  int data;
//  Node left;
//  Node right;
//  public Node(int key) {
//      data = key;
//  }
// }

import java.util.*;

public class Solution {
    public static List<Integer> levelOrder(TreeNode<Integer> root) {
        // Write your code here.
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        List<Integer> wrapList = new ArrayList<>();
        if (root == null)
            return wrapList;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> node = q.poll();
            wrapList.add(node.data);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return wrapList;
    }
}
