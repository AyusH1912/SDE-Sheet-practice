// All in one DFS traversal using a stack and a count in pair form i.e., count = 1 denotes pre, 2 = in and 3 = postOrder Traversal

import java.util.*;

public class preInPostTraversal {
    public void allTraversal(TreeNode root) {
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null)
            return;

        while (!s.isEmpty()) {
            Pair it = s.pop();
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                s.push(it);
                if (it.node.left != null) {
                    s.push(new Pair(it.node.left, 1));
                }
            } else if (it.num == 2) {
                in.add(it.node.val);
                it.num++;
                s.push(it);
                if (it.node.right != null) {
                    s.push(new Pair(it.node.right, 1));
                }
            } else {
                post.add(it.node.val);
            }
        }
    }
}
