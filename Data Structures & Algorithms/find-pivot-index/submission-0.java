class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int leftSum = 0;
        int rightSum = 0;
        for(int i=1; i<n; ++i){
            leftSum += nums[i-1];
            left[i] = leftSum;
        }

        for(int i=n-2; i>=0; --i){
            rightSum += nums[i+1];
            right[i] = rightSum;
        }

        for(int i=0; i<n; ++i){
            if(left[i] == right[i]) return i;
        }

        return -1;

    }
}