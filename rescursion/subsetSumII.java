//This code is Leetcode subset sum 2 problem solution solved using RECURSION.
//Problem identification: we have to make a choice using take or not take logic and checing that no duplicate elements are added again.
//Problem link: https://leetcode.com/problems/subsets-ii/
//Explanation: https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/
//Leetcode Medium Problem

class Solution {
    public static void findSubset(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;
            ds.add(nums[i]);
            findSubset(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}