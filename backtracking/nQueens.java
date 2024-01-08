//This code is Leetcode N-Queens problem solution solved using RECURSION and BACKTRACKING Approach 1.
//Problem identification: we have to make all permutations which are possible from the given conditions.
//Problem link: https://leetcode.com/problems/n-queens/
//Explanation: https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/
//Leetcode Hard Problem
//Time Complexity = O(N! x N) i.e., N! because we are almost trying all the possibilities.

class Solution {
    private boolean isSafe(int i, int j, char[][] board, int n) {
        int drow = i;
        int dcol = j;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        i = drow;
        j = dcol;
        while (j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            j--;
        }

        i = drow;
        j = dcol;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }

        return true;
    }

    private List<String> build(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(build(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
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
        solve(0, board, ans, n);
        return ans;
    }
}