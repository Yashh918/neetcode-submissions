class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;

        while(i < n){
            if(nums[i] <= nums[i-1]){
                int j = i;
                while(j<n && nums[j] <= nums[i-1]){
                    ++j;
                }
                if(j == n) break;
                nums[i] = nums[j];
            }
            ++i;
        }
        return i;
    }
}