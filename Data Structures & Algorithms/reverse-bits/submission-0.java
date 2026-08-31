class Solution {
    public int reverseBits(int n) {
        int mask = 1;
        int res = 0;

        for(int i=0; i<32; ++i){
            if((n & mask) == mask){
                res = res << 1;
                res += 1;
            } else {
                res = res << 1;
            }

            mask = mask << 1;
        }

        return res;
    }
}
