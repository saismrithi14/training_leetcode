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
class validate_BST {
    private boolean isValidRangeBST(TreeNode root, long left, long right)
    {
        if(root == null)
        {
            return true;
        }

        boolean left_valid = isValidRangeBST(root.left, left, root.val);
        boolean right_valid = isValidRangeBST(root.right, root.val, right);

        return left_valid && right_valid && left < root.val && root.val < right;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidRangeBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
}