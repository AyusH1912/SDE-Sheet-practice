// Problem link: https://www.codingninjas.com/codestudio/problems/ninja-and-the-second-order-elements_6581960?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
// TC: O(N), we are finding largest and smallest in a single pass and then finding second largest and smallest in another pass without using any sort inbuilt method which will use O(NlogN)

public class Solution {
    public static int[] getSecondOrderElements(int n, int[] arr) {
        // Write your code here.
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            small = Math.min(small, arr[i]);
            large = Math.max(large, arr[i]);
        }
        for (i = 0; i < n; i++) {
            if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
            if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        int ans[] = new int[2];
        ans[0] = second_large;
        ans[1] = second_small;
        return ans;
    }
}