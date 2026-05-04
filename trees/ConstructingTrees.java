import java.util.*;
class Pair
{
    public int depth;
    public TreeNode node;

    public Pair(int depth, TreeNode node)
    {
        this.depth = depth;
        this.node = node;
    }

    public String toString() {
        return "Depth: " + depth + ", Node: " + node.val;
    }
}


public class ConstructingTrees {
    public static TreeNode recoverFromPreorder(String traversal) {
        Stack<Pair> stack = new Stack<>();
        int i = 0;
        int firstNum = 0;
        while(i<traversal.length() && traversal.charAt(i)!= '-')
        {
            firstNum = (firstNum * 10) + (traversal.charAt(i) - '0');
            i++;
        }

        TreeNode firstNode = new TreeNode(firstNum);
        stack.push(new Pair(0,firstNode));
        int count = 0;
        while(i<traversal.length())
        {
            if(traversal.charAt(i)=='-') {
                count++;
                i++;
            }
            else
            {

                int num = 0;
                while(i<traversal.length() && traversal.charAt(i)!= '-')
                {
                    num = (num*10) + traversal.charAt(i) - '0';
                    i++;
                }
                TreeNode node = new TreeNode(num);
                Pair new_pair = new Pair(count,node);
                count = 0;
                while(!stack.isEmpty() && new_pair.depth <= stack.peek().depth)
                {
                    stack.pop();
                }

                if(!stack.isEmpty() && stack.peek().node.left==null)
                {
                    stack.peek().node.left = new_pair.node;
                }
                else
                {
                    if(!stack.isEmpty()) stack.peek().node.right = new_pair.node;
                }

                stack.push(new_pair);
            }

        }
        TreeNode finalNode = null;
        for(Pair pair: stack)
        {
            finalNode = pair.node;
            break;

        }
        return finalNode;
    }
   public static void main(String[] args)
   {
        String traversal = "1-12--123--45-6--78";
       System.out.println("Root node to traverse the tree is: " + recoverFromPreorder(traversal));
   }
}
