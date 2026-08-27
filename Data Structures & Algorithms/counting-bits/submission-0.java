class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<n+1; ++i){
            ans[i] = bits(i);
        }

        return ans;
    }

    public int bits(int n){
        int mask = 1;
        int ans = 0;
        for(int i=0; i<32; ++i){
            if((n & mask) == mask){
                ans++;
            }

            mask = mask << 1;
        }

        return ans; 
    }
}
