// Bubble sort algorithm 
// Not suitable for long input data as it takes O(n^2)
// After each pass or i the last element of the array gets sorted and we run one time less in next iteration

int n = nums.length;
for (int i = 0; i<n-1; i++) {
    for(int j = 0; j<n-i-1; j++) {
        if(nums[j]>nums[j+1]) {
            int temp = nums[j];
            nums[j] = nums[j+1];
            nums[j+1] = temp;
        }
    }
}