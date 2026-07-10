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
    public void traverse(TreeNode root, List<Integer> list, int k){
        if(root == null) return;
        
        traverse(root.left, list, k);
        list.add(root.val);
        if(list.size() == k) return;
        traverse(root.right, list, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list, k);
        return list.get(k-1);
    }
}
