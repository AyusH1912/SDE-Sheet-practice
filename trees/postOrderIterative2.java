// Using single Stack
// Explanation: https://takeuforward.org/data-structure/post-order-traversal-of-binary-tree/

public class Solution {
    public static List<Integer> getPostOrderTraversal(TreeNode root) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    ans.add(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        ans.add(temp.data);
                    }
                } else
                    curr = temp;
            }
        }
        return ans;
    }
}