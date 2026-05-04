import java.util.*;

 public class average_of_levels {
    private HashMap<Integer, List<Integer>> map = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root)
    {
        traversal(root, map,0);
        List<Double> final_list = new ArrayList<>();
        map.forEach((key,value)->{
            final_list.add(value.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0));
        });

        return final_list;

    }

    private void traversal(TreeNode root, HashMap<Integer, List<Integer>> map,int depth)
    {
        if(root == null)
        {
            return;
        }

        if(!map.containsKey(depth))
        {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(depth, list);
        }

        else
        {
            map.get(depth).add(root.val);
        }

        traversal(root.left, map, depth+1);
        traversal(root.right, map, depth+1);
    }
}