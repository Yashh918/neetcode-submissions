class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        
        int x = 0;
        int y = n-1;

        for(int i=0; i<n; ++i){
            if(nums[i] == 0 && x < i){
                swap(i--, x++, nums);
            } else if(nums[i] == 2 && y > i){
                swap(i--, y--, nums);
            }
        }
    }

    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}