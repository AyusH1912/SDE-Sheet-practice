// Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Solved using O(n), using one extra variable minPrice, if using O(n^2) i.e., Brute force solution it will throw a TLE.

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        // for (int i=0; i<prices.length; i++) { //O(n^2) Approach
        // for(int j=i+1; j<prices.length; j++) {
        // if (prices[j]>prices[i]) maxProfit = Math.max(maxProfit, prices[j] -
        // prices[i]);
        // }
        // }
        return maxProfit;
    }
}