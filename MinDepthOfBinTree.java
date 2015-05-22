/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinDepthOfBinTree {
    
    private int minDepth = Integer.MAX_VALUE;
    private int level = 1;
    
    private void traverseTree(TreeNode root) {
        if(root == null)
            return;
            
        if(root.left == null && root.right == null) {
            if(level < minDepth) {
                minDepth = level;
            }
        }
        if(root.left != null) {
            level++;
            traverseTree(root.left);
            level--;
        }
        if(root.right != null) {
            level++;
            traverseTree(root.right);
            level--;
        }
    }
    
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        traverseTree(root);
        return minDepth;
    }
}
