import java.util.*;

class SolutionTree {
    private int total_sum = 0;
    private int current_sum = 0;
    public int sumNumbers(TreeNode root) {
        sumToRoot(root);
        return total_sum;

    }

    private void sumToRoot(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        current_sum = current_sum * 10 + root.val;
        int local_sum = current_sum;
        if(root.left == null && root.right == null)
        {
            total_sum += current_sum;
            return;
        }

        sumToRoot(root.left);
        current_sum = local_sum;
        sumToRoot(root.right);
    }

}

public class sumRootToLeafNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read entire line
        String[] values = {"1","2","null","5", "6", "7", "8", "null", "7", "9"};

        TreeNode root = buildTree(values);

        SolutionTree sol = new SolutionTree();
        int result = sol.sumNumbers(root);

        System.out.println("Result: " + result);
    }


    private static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            if (i >= values.length) break;

            // Right child
            if (!values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}

