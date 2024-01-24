// Leetcode medium problem
// using 3 pointers
// O(N) time complexity and in-place solution
// Problem link: https://leetcode.com/problems/sort-colors/
// Explanation: https://www.youtube.com/watch?v=tp8JIuCXBaU&t=1s

class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1)
                mid++;
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}