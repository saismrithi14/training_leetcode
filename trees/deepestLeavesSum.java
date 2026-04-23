import java.util.*;
public class deepestLeavesSum {
    private static int total_sum = 0;
    private static int heightOfTree(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private static void deepestLeaves(TreeNode root,int currentHeight ,int height)
    {
        if(root == null) return;
        if(currentHeight == height)
        {
            total_sum += root.val;
            System.out.println("Current value of root: " + root.val);
        }

        deepestLeaves(root.left,currentHeight+1,height);
        deepestLeaves(root.right,currentHeight+1,height);

    }

    public static int deepestLeavesSum(TreeNode root) {
        int height = 0;
        height = heightOfTree(root);
        System.out.println("Height of tree: " + height);
        deepestLeaves(root,1,height);
        return total_sum;

    }
    public static void main(String[] args) {
        String input = "[1,2,3,4,5,null,6,7,null,null,null,null,8]";

        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(parts[0].trim()));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < parts.length) {
            TreeNode cur = q.poll();

            if (i < parts.length && !parts[i].trim().equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(parts[i].trim()));
                q.offer(cur.left);
            }
            i++;

            if (i < parts.length && !parts[i].trim().equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(parts[i].trim()));
                q.offer(cur.right);
            }
            i++;
        }

        System.out.println(deepestLeavesSum(root));
    }
}
