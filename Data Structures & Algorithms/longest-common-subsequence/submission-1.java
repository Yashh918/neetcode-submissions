class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        Map<String, Integer> map = new HashMap<>();

        return dfs(s1, s2, 0 ,0, map);
    }

    public int dfs(char[] s1, char[] s2, int i, int j, Map<String, Integer> map){
        if(i >= s1.length || j >= s2.length) {
            return 0;
        }

        if(map.containsKey(String.format("%d+%d",i ,j))){
            return map.get(String.format("%d+%d",i ,j));
        }

        int result = 0;
        if(s1[i] == s2[j]){
            result =  1 + dfs(s1, s2, i+1, j+1, map);
        } else {
            result = Math.max(dfs(s1, s2, i+1, j, map), dfs(s1, s2, i, j+1, map));
        }

        map.put(String.format("%d+%d",i ,j), result);
        return result;
    }
}
