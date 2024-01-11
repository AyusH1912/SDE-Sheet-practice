// GeeksforGeeks question - Rat in A Maze-1 - Backtracking
// Medium Level
// We have to solve the problem in lexicographical order so in order to achieve it we are using directions in DLRU manner every time
// Solved in two ways, second one is to optimize the length of the code for direction checking
// Problem link: https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// Explanation: https://takeuforward.org/data-structure/rat-in-a-maze/

class Solution {
    private static void solve(int i, int j, ArrayList<String> ans, int[][] m, int n, String ds, int[][] vis, int[] di,
            int[] dj) {
        if (i == n - 1 && j == n - 1) {
            ans.add(ds);
            return;
        }

        // //downward direction
        // if(i + 1 < n && vis[i+1][j] == 0 && m[i+1][j] == 1) {
        // vis[i][j] = 1;
        // solve(i+1, j, ans, m, n, ds+'D', vis);
        // vis[i][j] = 0;
        // }

        // //leftward direction
        // if(j - 1 >= 0 && vis[i][j-1] == 0 && m[i][j-1] == 1) {
        // vis[i][j] = 1;
        // solve(i, j-1, ans, m, n, ds+'L', vis);
        // vis[i][j] = 0;
        // }

        // //rightward direction
        // if(j + 1 < n && vis[i][j+1] == 0 && m[i][j+1] == 1) {
        // vis[i][j] = 1;
        // solve(i, j+1, ans, m, n, ds+'R', vis);
        // vis[i][j] = 0;
        // }

        // //upward direction
        // if(i - 1 >= 0 && vis[i-1][j] == 0 && m[i-1][j] == 1) {
        // vis[i][j] = 1;
        // solve(i-1, j, ans, m, n, ds+'U', vis);
        // vis[i][j] = 0;
        // }

        // easiest way to code above in short
        String move = "DLRU"; // Lexicographical order
        for (int x = 0; x < 4; x++) {
            int nexti = i + di[x];
            int nextj = j + dj[x];
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && m[nexti][nextj] == 1) {
                vis[i][j] = 1;
                solve(nexti, nextj, ans, m, n, ds + move.charAt(x), vis, di, dj);
                vis[i][j] = 0;
            }
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        int di[] = { 1, 0, 0, -1 };
        int dj[] = { 0, -1, 1, 0 };
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1)
            solve(0, 0, ans, m, n, "", vis, di, dj);
        return ans;
    }
}
