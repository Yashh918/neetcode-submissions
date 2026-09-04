class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int front = 0;
        int rear = 0;
        int total = 0;
        int n = nums.length;
        int ans = 0;
        int min = Integer.MAX_VALUE;

        while(front < n){
            while(total < target){
                if(front == n) break;
                total += nums[front++];
            }

            while(total >= target){
                ans = front - rear;
                min = Math.min(min, ans); 
                total -= nums[rear++];
            }
        }

        if(ans != 0) return min;
        return ans;

    }
}