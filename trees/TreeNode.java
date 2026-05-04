class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        String leftStr = (left != null) ? left.toString() : "null";
        String rightStr = (right != null) ? right.toString() : "null";
        return val + " -> (" + leftStr + ", " + rightStr + ")";
    }
}
