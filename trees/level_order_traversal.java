/**
 * Definition for a binary tree node.
 */
import java.util.*;

public class level_order_traversal{
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        traversal(root, map, 0);
        List<List<Integer>> final_list = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet())
        {
            final_list.add(entry.getValue());
        }

        return final_list;
    }

    private void traversal(TreeNode root, HashMap<Integer, List<Integer>> map, int depth)
    {
        if(root == null)
        {
            return;
        }

        if(!map.containsKey(depth))
        {
            ArrayList<Integer> a1 = new ArrayList<>();
            a1.add(root.val);
            map.put(depth, a1);
        }

        else
        {
            map.get(depth).add(root.val);
        }

        traversal(root.left, map, depth+1);
        traversal(root.right, map, depth+1);
    }
}