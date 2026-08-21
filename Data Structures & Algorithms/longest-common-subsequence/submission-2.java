class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length][s2.length];

        return dfs(s1, s2, 0 ,0, dp);
    }

    public int dfs(char[] s1, char[] s2, int i, int j, int[][] dp){
        if(i >= s1.length || j >= s2.length) {
            return 0;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int result = 0;
        if(s1[i] == s2[j]){
            result =  1 + dfs(s1, s2, i+1, j+1, dp);
        } else {
            result = Math.max(dfs(s1, s2, i+1, j, dp), dfs(s1, s2, i, j+1, dp));
        }

        dp[i][j] = result;
        return result;
    }
}
