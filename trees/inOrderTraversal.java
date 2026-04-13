import java.util.*;
public class inOrderTraversal
{
    private void traversal(TreeNode root, List<Integer> list)
    {
        if(root == null) return;
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> final_list = new ArrayList<>();
        traversal(root,final_list);
        return final_list;
    }
}