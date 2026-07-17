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
        dfs(nums, target - nums[i], i, subset, res);
        subset.remove(subset.size()-1);
        dfs(nums, target, i+1, subset, res);
    }
}
