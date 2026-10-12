class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int max = 1;

        for (int i = 1; i < n; ++i) {
            int curr_max = 1;
            int sign = 0;
            int prev = 0;
            for (int j = i; j < n; ++j) {
                if (arr[j] > arr[j - 1]) {
                    sign = 1;
                } else if (arr[j] < arr[j - 1]) {
                    sign = -1;
                } else {
                    sign = 0;
                }

                if (prev == sign || sign == 0) {
                    break;
                }

                curr_max++;
                max = Math.max(max, curr_max);
                prev = sign;
            }
        }

        return max;
    }
}