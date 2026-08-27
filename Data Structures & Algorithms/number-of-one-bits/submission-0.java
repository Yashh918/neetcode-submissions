class Solution {
    public int hammingWeight(int n) {
        int bitmask = 1;
        int ans = 0;
        for(int i=0; i<32; ++i){
            if((n & bitmask) == bitmask) {
                ans++;
            }

            bitmask = (bitmask << 1);
        }

        return ans;
    }
}
