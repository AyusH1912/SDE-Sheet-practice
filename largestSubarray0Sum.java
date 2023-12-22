import java.util.*;

class largestSubarray0Sum {
    int maxLen(int arr[], int n) {
        // Prefix sum solution
        int maxLen = 0;
        int s = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if (s == 0) {
                maxLen = Math.max(maxLen, i + 1); // Always check whether it sum = K is present from the starting of the
                                                  // array
            }
            int rem = s - 0; // s - k (reverse engineering for finding the subarray i.e., for some subarray
                             // sum to be k there should be a subarray s-k)
            if (hmap.containsKey(rem)) { // check whether it is present in the hashmap if present then update the maxLen
                                         // by calculating the len
                int len = i - hmap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!hmap.containsKey(rem)) { // if not then add the sum till that and keep the index also in the map
                hmap.put(s, i);
            }
        }
        return maxLen;
    }
}
