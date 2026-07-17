class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, target, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> subset, List<List<Integer>> res){
        if(target < 0){
            return;
        }
        
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        
        if(i >= nums.length){
            return;
        }
        
        subset.add(nums[i]);
        target -= nums[i];
        dfs(nums, target, i, subset, res);
        target += nums[i];
        subset.remove(subset.size()-1);
        
        int j = i+1;
        while(j < nums.length){
            subset.add(nums[j]);
            target -= nums[j];
            dfs(nums, target, j, subset, res);
            target += nums[j];
            subset.remove(subset.size()-1);
            ++j;
        }
    }
}
