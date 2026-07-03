class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        int ans = 0;

        for(int i=0; i<n; ++i){
            max = Math.max(max, piles[i]);
        }
        ans = max;

        int l = 1;
        int r = max;

        if(isValid(piles, h, l)) {
            return l;
        }

        while(l < r-1){
            int middle = l + (r-l)/2;

            if(isValid(piles, h, middle)){
                ans = middle;
                r = middle;
            } else {
                l = middle;
            }
        }

        return ans;
    }

    public boolean isValid(int[] piles, int h, int k){
        double totalHours = 0;

        for(int pile : piles){
            totalHours += Math.ceil((double) pile/k);
        }

        if((int) totalHours <= h) {
            return true;
        }else {
            return false;
        }
    }
}
