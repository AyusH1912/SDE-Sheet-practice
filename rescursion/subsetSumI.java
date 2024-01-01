//This code is gfg practice subset sum problem solution solved using RECURSION.
//Problem identification: we have to make a choice using take or not take logic and carry a sum variable to add it in the final solution array and return.
//Problem link: https://practice.geeksforgeeks.org/problems/subset-sums2234/1
//Explanation: https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
//GeeksForGeeks Medium Problem

class Solution {
    void sum(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSet) {
        if (ind == N) {
            sumSet.add(sum);
            return;
        }
        // pick
        sum(ind + 1, sum + arr.get(ind), arr, N, sumSet);
        // not pick
        sum(ind + 1, sum, arr, N, sumSet);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> sumSet = new ArrayList<>();
        sum(0, 0, arr, N, sumSet);
        Collections.sort(sumSet);
        return sumSet;
    }
}