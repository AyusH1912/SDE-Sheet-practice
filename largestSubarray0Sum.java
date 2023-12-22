import java.util.*;

class largestSubarray0Sum {
    int maxLen(int arr[], int n) {
        // Your code here
        int maxLen = 0;
        int s = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if (s == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = s - 0;
            if (hmap.containsKey(rem)) {
                int len = i - hmap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!hmap.containsKey(rem)) {
                hmap.put(s, i);
            }
        }
        return maxLen;
    }
}
