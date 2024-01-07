//This code is Leetcode Permutation problem solution solved using RECURSION Approach 2.
//Problem identification: we have to make all permutations which are possible from the given arr.
//Problem link: https://leetcode.com/problems/permutations/
//Explanation: https://takeuforward.org/data-structure/print-all-permutations-of-a-string-array/
//Leetcode Medium Problem

class Solution {
    private void arrPerm(int ind, int[] nums, List<List<Integer>> ans) { // Approach 2 space optimization
        if (ind == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            arrPerm(ind + 1, nums, ans);
            swap(i, ind, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> ds = new ArrayList<>();
        // boolean[] flag = new boolean[nums.length];
        arrPerm(0, nums, ans);
        return ans;
    }
}