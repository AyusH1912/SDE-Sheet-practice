// This code is Leetcode Sudoku Solver problem solution solved using RECURSION and BACKTRACKING.
// Problem identification: we have to make all permutations which are possible from the given conditions.
// Problem link: https://leetcode.com/problems/sudoku-solver/
// Explanation: https://takeuforward.org/data-structure/sudoku-solver/
// Leetcode Hard Problem
// Time Complexity: O(9^(n^2)), in the worst case, for each cell in the n^2 board, we have 9 possible ways of filling it.
// Space Complexity: O(1) inplace we are solving.
// Formula for third condition i.e., to check whether the element is present in the 3x3 cell we use the following : (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c).

class Solution {
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false; // if the following combination not possible.
                }
            }
        }
        return true; // if not found any '.'.
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) // Row constant
                return false;
            if (board[i][col] == c) // Column constant
                return false;
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c) // to check whether the element is present
                                                                              // in the cell or not.
                return false;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}