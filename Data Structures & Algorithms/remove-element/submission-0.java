class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while(j < nums.length){
            nums[i] = nums[j];
            if(nums[j] != val){
                ++i;
            }
            ++j;
        }

        return i;
    }
}