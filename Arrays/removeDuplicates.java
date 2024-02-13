// Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Explanation: https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        // HashSet<Integer> hset = new HashSet<>(); //O(NlogN)+O(N) Approach
        // for (int i=0; i<nums.length; i++) {
        // hset.add(nums[i]);
        // }
        // int s = hset.size();
        // int x = 0;
        // for (int auto : hset) {
        // nums[x++] = auto;
        // }
        // return s;

        int i = 0;
        for (int j = 1; j < nums.length; j++) { // O(N) Approach using two pointers
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
