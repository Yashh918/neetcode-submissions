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
    int preorderIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        for(int i=0; i<n; ++i){
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, n-1);
    }

    public TreeNode dfs(int[] preorder, int left, int right){      
        if(left > right) return null;

        int rootVal = preorder[preorderIndex++];

        int middle = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = dfs(preorder, left, middle-1);
        root.right = dfs(preorder, middle+1, right);

        return root;
    }
}
