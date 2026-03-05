public class BinaryTreeLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return a node, root is LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null side
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        BinaryTreeLCA tree = new BinaryTreeLCA();
        TreeNode p = root.left.right.left; // Node 7
        TreeNode q = root.left.right.right; // Node 4

        TreeNode lca = tree.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }

}
