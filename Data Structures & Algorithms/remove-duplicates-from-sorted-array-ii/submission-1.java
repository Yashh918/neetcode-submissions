class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 2;
        for(int i=2; i<n; ++i){
            if(nums[i] == nums[k-1] && nums[k-2] != nums[i]){
                nums[k] = nums[k-1];
                ++k;
            } else if(nums[i] != nums[k-1]) {
                nums[k] = nums[i];
                ++k;  
            }
        }

        return k;
    }
}