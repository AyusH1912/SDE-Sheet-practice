// Using two methods 1) using string and stringbuilder 2) with reverse a number
// O(logn) for reversing a number
// Problem link: https://leetcode.com/problems/palindrome-number/

class Solution {
    public int reverse(int x) {
        int y = 0;
        while (x > 0) {
            int digit = x % 10;
            y = y * 10 + digit;
            x = x / 10;
        }
        return y;
    }

    public boolean isPalindrome(int x) {
        // String num = String.valueOf(x);
        // StringBuilder revNum = new StringBuilder(num).reverse();
        // if (revNum.toString().equals(num)) return true;
        // return false;
        int dummy = x;
        int res = reverse(x);
        if (res == dummy)
            return true;
        return false;
    }
}