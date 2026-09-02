class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = 0;
        int currSum = 0;
        int min = nums[0];
        int max = nums[0];

        // min subarray
        for (int i=0; i<n; ++i) {     
            total += nums[i];
            currSum += nums[i];
            min = Math.min(min, currSum);
            currSum = Math.min(currSum, 0);
        }

        // max subarray
        currSum = 0;
        for (int i=0; i<n; ++i) {     
            currSum += nums[i];
            max = Math.max(max, currSum);
            currSum = Math.max(currSum, 0);
        }

        if(total == min) return max;
        
        return Math.max(max, total-min);
    }
}