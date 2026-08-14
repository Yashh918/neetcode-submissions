class Solution {
    public int climbStairs(int n) {
      int[] cache = new int[n+1];
      cache[0] = 0;
      cache[1] = 1;

      return paths(n, cache);
    }

    public int paths(int n, int[] cache){
        if(n == 0 || n == 1) return 1;
        if(cache[n] != 0){
            return cache[n];
        }

        int result =  paths(n-1, cache) + paths(n-2, cache);
        cache[n] = result;

        return result;
    }
}
