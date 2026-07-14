/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean hasSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return hasSum;
    }

    public void dfs(TreeNode root, int target) {
        if(root == null ) return;
        
        if (root.left == null && root.right == null) {
            if (target - root.val == 0) {
                hasSum = true;
            }

            return;
        }

        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
    }
}