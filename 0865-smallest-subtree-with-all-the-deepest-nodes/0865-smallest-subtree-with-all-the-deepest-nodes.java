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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
     int maxDepth = height(root);
        return dfs(root, maxDepth, 0); //0 -> current depth
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public TreeNode dfs(TreeNode root, int maxDepth, int depth){
        if(root == null) return null;
        if(depth == maxDepth -1) return root;

        TreeNode Left = dfs(root.left, maxDepth, depth +1);
        TreeNode Right = dfs(root.right, maxDepth, depth +1);

        if(Left != null && Right != null) return root;
        
        return Left != null ? Left : Right;
    }
}