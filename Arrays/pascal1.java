// Leetcode Easy problem
// 1
// 1 1
// 1 2 1
// 1 3 3 1 -> Pascal's Triangle
// nCr formula in short do ans*=(n-i)/(i+1) to get any particular row col element from the triangle
// Explanation: https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
// Problem Link: https://leetcode.com/problems/pascals-triangle/

class Solution {
    public static List<Integer> nCr(int n) {
        long res = 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i < n; i++) {
            res = res * (n - i);
            res = res / i;
            ans.add((int) res);
        }
        return ans;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(nCr(i));
        }
        return ans;
    }
}
