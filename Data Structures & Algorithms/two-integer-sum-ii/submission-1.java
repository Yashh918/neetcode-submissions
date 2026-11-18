class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int targetIdx = -1;
        int l = 0;
        int r = n-1;

        for(int i=0; i<n; ++i){
            int newTarget = target - nums[i];
            if(newTarget < nums[i]){
                r = i-1;
            } else {
                l = i+1;
            }
            targetIdx = search(nums, newTarget, l, r);
            if(targetIdx != -1){
                if (targetIdx > i){
                    return new int[]{i+1, targetIdx+1};
                } else{
                    return new int[]{targetIdx+1, i+1};
                }
            }
        }

        return new int[]{};
        
    }

    public int search(int[] nums, int target, int l, int r){
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] == target) {
                return m;
            } else if (nums[m] > target){
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return -1;
    }
}
