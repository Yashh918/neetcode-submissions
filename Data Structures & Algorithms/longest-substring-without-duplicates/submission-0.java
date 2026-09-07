class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        int i = 0;
        int j = 0;
        int n = arr.length;
        int max = 0;
        int curr = 0;

        while (i < n) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            curr++;

            while (map.get(arr[i]) > 1) {
                map.put(arr[j], map.get(arr[j]) - 1);
                --curr;
                ++j;
            }

            max = Math.max(max, curr);
            ++i;
        }

        return max;
    }
}
