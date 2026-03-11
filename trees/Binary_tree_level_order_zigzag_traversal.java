import java.util.*;
class Binary_tree_level_order_zigzag_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> final_list = new ArrayList<>();
        if(root != null)
        {
            s1.push(root);
        }


        while(!s1.isEmpty() || !s2.isEmpty())
        {
            List<Integer> sub_list = new ArrayList<>();
            if(!s1.isEmpty())
            {
                while(!s1.isEmpty())
                {
                    TreeNode node = s1.pop();
                    sub_list.add(node.val);
                    if(node.left != null)
                    {
                        s2.push(node.left);
                    }

                    if(node.right != null)
                    {
                        s2.push(node.right);
                    }
                }
            }

            else
            {

                while(!s2.isEmpty())
                {
                    TreeNode node = s2.pop();
                    sub_list.add(node.val);
                    if(node.right != null)
                    {
                        s1.push(node.right);
                    }
                    if(node.left != null)
                    {
                        s1.push(node.left);
                    }
                }
            }


            final_list.add(sub_list);
        }

        return final_list;

    }
}