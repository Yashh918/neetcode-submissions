class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int max = nums[0];

        for(int num : nums){
            currSum += num;
            max = Math.max(max, currSum);
            currSum = Math.max(currSum, 0);
        }

        return max;
    }
}
