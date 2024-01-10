// Leetcode Medium Problem
// We are maintaining circular kind of an array and iterating 2 times on it i.e., from last to starting 2*n-1 to 0 and to index it we are doing (i%n).
// Using Stack
// Problem link: https://leetcode.com/problems/next-greater-element-ii/
// Explanation: https://takeuforward.org/data-structure/next-greater-element-using-stack/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n])
                st.pop();

            if (i < n) { // we are maintaining an increasing order of the stack
                if (!st.isEmpty())
                    ans[i] = st.peek();
                else
                    ans[i] = -1;
            }

            st.push(nums[i % n]);
        }
        return ans;
    }
}