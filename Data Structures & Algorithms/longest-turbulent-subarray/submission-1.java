class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int max = 1;
        int curr_max = 1;
        int i = 1;
        int j = 1;
        int sign = 0;
        int prev = 0;

        while (j < n) {
            if (arr[j] > arr[j - 1]) {
                sign = 1;
            } else if (arr[j] < arr[j - 1]) {
                sign = -1;
            } else {
                sign = 0;
            }

            if (prev == sign || sign == 0) {
                curr_max = 1;
                if (sign == 0) {
                    ++j;
                }
                i = j;
                prev = 0;
                continue;
            }

            curr_max++;
            max = Math.max(max, curr_max);
            prev = sign;
            ++j;
        }

        return max;
    }
}