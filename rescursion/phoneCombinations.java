// LeetCode Medium Recursion and Backtracking Question
// Time Complexity: O(4^n), where n is the length of the input, in the worst case, each digit can represent 4 letters.
// Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/ 

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty())
            return ans;

        String[] phone_map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        phone_combination("", digits, phone_map, ans);
        return ans;
    }

    private void phone_combination(String comb, String digits, String[] phone_map, List<String> ans) {
        if (digits.isEmpty()) {
            ans.add(comb);
        } else {
            String letters = phone_map[digits.charAt(0) - '2'];
            for (char l : letters.toCharArray()) {
                phone_combination(comb + l, digits.substring(1), phone_map, ans);
            }
        }
    }
}