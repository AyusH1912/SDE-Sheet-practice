//This code is Leetcode Permutation problem solution solved using RECURSION Approach 1.
//Problem identification: we have to make all permutations which are possible from the given arr.
//Problem link: https://leetcode.com/problems/permutations/
//Explanation: https://takeuforward.org/data-structure/print-all-permutations-of-a-string-array/
//Leetcode Medium Problem

class Solution {
    private void arrPerm(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] flag) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                ds.add(nums[i]);
                arrPerm(nums, ans, ds, flag);
                ds.remove(ds.size() - 1);
                flag[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        arrPerm(nums, ans, ds, flag);
        return ans;
    }
}