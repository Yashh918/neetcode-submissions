class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        int k = 1;
        for(int i=1; i<n; ++i){
            if(nums[i] == nums[k-1] && map.get(nums[i]) < 2){
                nums[k] = nums[k-1];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                ++k;
            } else if(nums[i] != nums[k-1]) {
                nums[k] = nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                ++k;  
            }
        }

        return k;
    }
}