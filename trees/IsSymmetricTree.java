public class IsSymmetricTree {
    private boolean isSymmetric2Pointers(TreeNode rootLeft, TreeNode rootRight)
    {
        if((rootLeft!=null && rootRight == null)||(rootLeft==null && rootRight!=null)) return false;
        if(rootLeft==null && rootRight==null) return true;

        return isSymmetric2Pointers(rootLeft.left,rootRight.right) && isSymmetric2Pointers(rootLeft.right, rootRight.left) && rootLeft.val == rootRight.val;
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode rootLeft = root, rootRight = root;
        return isSymmetric2Pointers(rootLeft,rootRight);
    }
}
