import java.util.*;
public class PostOrderTraversal {
    List<Integer> finalList = new ArrayList<>();
    private void traversal(TreeNode root)
    {
        if(root == null) return;
        traversal(root.left);
        traversal(root.right);
        finalList.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return finalList;

    }
}
