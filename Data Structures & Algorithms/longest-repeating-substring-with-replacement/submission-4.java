class Solution {
    public int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int ans = 0;
        int[] map = new int[26];

        while (i < n) {
            int index = str[i] - 'A';
            map[index]++;
            maxFreq = Math.max(maxFreq, map[index]);

            while (i + 1 - j - maxFreq > k) {
                int removeIndex = str[j] - 'A';
                map[removeIndex]--;
                j++;
            }

            ans = Math.max(ans, i + 1 - j);
            ++i;
        }
        return ans;
    }
}
