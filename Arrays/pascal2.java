// Leetcode Easy problem
//      1
//    1   1 
//  1   2   1
//1   3   3   1 -> Pascal's Triangle
// nCr formula in short do ans*=(n-i)/(i+1) to get any particular row col element from the triangle
// Explanation: https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
// Problem Link: https://leetcode.com/problems/pascals-triangle-ii/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex == 0) {
            res.add(1);
            return res;
        }
        res.add(1); // start
        long ans = 1;
        for (int i = 0; i < rowIndex - 1; i++) {
            ans = ans * (rowIndex - i);
            ans = ans / (i + 1);
            res.add((int) ans);
        }
        res.add(1); // end
        return res;
    }
}