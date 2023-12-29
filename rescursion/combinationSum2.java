//This code is leetcode combination sum problem solution solved using RECURSION.
//Problem identification: we have to make a combination/choice without using same element(no duplicates[duplicates were used in combination sum 1]) in lexicographical order using take or not take logic.
//Problem link: https://leetcode.com/problems/combination-sum-ii/
//Explanation: https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/
//Leetcode Medium Problem

class Solution {
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}