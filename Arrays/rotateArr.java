// Problem Link: https://leetcode.com/problems/rotate-array/

class rotateArr {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // if k is greater than size of the arr
        int temp[] = new int[n];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }
        for (int i = 0; i < n - k; i++) {
            temp[k + i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
