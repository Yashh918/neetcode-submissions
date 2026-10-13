class Solution {
    public boolean isAlphanumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }

        return false;
    }

    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();

        int n = arr.length;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            while(!isAlphanumeric(arr[i]) && (i < j)){
                ++i;
            }
            while(!isAlphanumeric(arr[j]) && (i < j)){
                --j;
            }

            if(i >= j){
                break;
            }

            if(Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])){
                return false;
            }

            ++i;
            --j;

        }

        return true;
    }
}
