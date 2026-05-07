import java.util.*;
public class levelOrderTraversal2 {
    private void traversal(TreeNode root, int depth, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        if (map.containsKey(depth)) {
            map.get(depth).add(root.val);
        } else {
            ArrayList<Integer> a1 = new ArrayList<>();
            a1.add(root.val);
            map.put(depth, a1);
        }

        traversal(root.left, depth + 1, map);
        traversal(root.right, depth + 1, map);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        traversal(root, 0, map);
        List<List<Integer>> list = new ArrayList<>(map.values());
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            List<Integer> temp = list.get(right);
            list.set(right, list.get(left));
            list.set(left, temp);
            left++;
            right--;
        }

        return list;
    }
}
