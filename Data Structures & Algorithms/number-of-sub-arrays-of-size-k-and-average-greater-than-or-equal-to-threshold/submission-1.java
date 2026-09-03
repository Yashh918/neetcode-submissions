class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int front = 0;
        int rear = 0;
        int runningSum = 0;
        int n = arr.length;
        
        while(front < k-1){
            runningSum += arr[front];
            front++;
        }

        while(front < n){
            runningSum += arr[front++];

            if(runningSum/k >= threshold ){
                ans++;
            }

            runningSum -= arr[rear++];
        }

        return ans;
    }
}