// This code is Leetcode N-Queens problem solution solved using RECURSION and BACKTRACKING Approach 2(space optimized using hashed array instead of iterations).
// Problem identification: we have to make all permutations which are possible from the given conditions.
// Problem link: https://leetcode.com/problems/n-queens/
// Explanation: https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
// Leetcode Hard Problem
// Time Complexity = O(N! x N) i.e., N! because we are almost trying all the possibilities.

class Solution {
    private List<String> build(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private void solve(int col, char[][] board, List<List<String>> ans, int leftRow[], int lowerDiagonal[],
            int upperDiagonal[], int n) {
        if (col == n) {
            ans.add(build(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row] == 0 && upperDiagonal[row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiagonal[(n - 1) + (col - row)] = 1;
                lowerDiagonal[row + col] = 1;
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[(n - 1) + (col - row)] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
        return ans;
    }
}