public class invertingTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left_node = invertTree(root.left);
        TreeNode right_node = invertTree(root.right);
        root.right = left_node;
        root.left = right_node;
        return root;

    }
}
