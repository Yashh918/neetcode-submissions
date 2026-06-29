class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n-1;
        int m;

        if(nums[l] == target) return l;
        if(nums[r] == target) return r;

        while(l < r-1){
            m = l + (r-l)/2;

            if(nums[m] == target) {
                return m;
            } else if(nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        
        return -1;
    }
}
