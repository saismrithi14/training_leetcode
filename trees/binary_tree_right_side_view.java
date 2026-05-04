import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        traversal(root, 0, map);
        ArrayList<Integer> final_list = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet())
        {
            int size = entry.getValue().size();
            final_list.add(entry.getValue().get(size - 1));
        }

        return final_list;
        
    }

    private void traversal(TreeNode root, int depth, HashMap<Integer, ArrayList<Integer>> map)
    {
        if(root == null)
        {
            return;
        }

        else
        {
            if(map.containsKey(depth))
            {
                map.get(depth).add(root.val);
            }

            else
            {
                ArrayList<Integer> a1 = new ArrayList<>();
                a1.add(root.val);
                map.put(depth, a1);
            }

            traversal(root.left, depth+1,map);
            traversal(root.right, depth+1,map);
        }
    }
}