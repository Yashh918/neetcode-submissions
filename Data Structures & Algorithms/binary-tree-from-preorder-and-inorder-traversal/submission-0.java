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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        int n = preorder.length;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int middle = 0;
        for(int i=0; i<n; ++i){
            if(inorder[i] == rootVal){
                middle = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, middle+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, middle+1, n);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, middle);
        int[] rightInorder = Arrays.copyOfRange(inorder, middle+1, n);


        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
