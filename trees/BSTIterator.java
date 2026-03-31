import java.util.*;
public class BSTIterator {
    List<Integer> bst_list;
    int random_ptr;
    public void dfs(TreeNode root, List<Integer> bst_list)
    {
        if(root==null) return;
        dfs(root.left,bst_list);
        bst_list.add(root.val);
        dfs(root.right,bst_list);
    }
    public BSTIterator(TreeNode root) {
        random_ptr = -1;
        bst_list = new ArrayList<Integer>();
        dfs(root,bst_list);

    }

    public int next() {
        random_ptr++;
        return bst_list.get(random_ptr);

    }

    public boolean hasNext() {
        return random_ptr + 1 < bst_list.size();
    }
}
