class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr_max = 0;

        for(int i=0; i<nums.length; ++i){
            if(nums[i] == 1) {
                curr_max++;
            } else {
                curr_max = 0;
            }

            max = curr_max > max ? curr_max : max;
        }

        return max;
    }
}