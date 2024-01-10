// This code is Leetcode Palindrome Partioning problem solution solved using RECURSION and BACKTRACKING.
// Problem identification: we have to make all permutations which are possible from the given conditions.
// Problem link: https://leetcode.com/problems/palindrome-partitioning/
// Explanation: https://takeuforward.org/data-structure/palindrome-partitioning/
// Leetcode Medium Problem

class Solution {
    private void solve(int ind, List<List<String>> ans, List<String> ds, String s) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                ds.add(s.substring(ind, i + 1));
                solve(i + 1, ans, ds, s);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        solve(0, ans, ds, s);
        return ans;
    }
}