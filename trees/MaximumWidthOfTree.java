import java.util.*;

class PairClass
{
    long firstIndex;
    long lastIndex;

    public PairClass()
    {
        this.firstIndex = Long.MAX_VALUE;
        this.lastIndex = Long.MIN_VALUE;
    }
}

class QueueNode{
    TreeNode node;
    long index;
    int level;

    public QueueNode(TreeNode node, int level, long index)
    {
        this.node = node;
        this.index = index;
        this.level = level;
    }
}

public class MaximumWidthOfTree {
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer,PairClass> hashMap = new HashMap<>();
        Queue<QueueNode> q = new ArrayDeque<>();
        long maxDifference = Long.MIN_VALUE;
        q.add(new QueueNode(root,0,0));
        while(!q.isEmpty())
        {
            QueueNode poppedNode = q.poll();
            long idx = poppedNode.index;
            int level = poppedNode.level;
            PairClass pair = hashMap.getOrDefault(level,new PairClass());
            pair.firstIndex = Math.min(pair.firstIndex, idx);
            pair.lastIndex = Math.max(pair.lastIndex, idx);
            hashMap.put(level,pair);

            if(poppedNode.node.left != null)
            {
                q.add(new QueueNode(poppedNode.node.left, level + 1,(2*idx)));
            }

            if(poppedNode.node.right != null)
            {
                q.add(new QueueNode(poppedNode.node.right,level + 1,(2*idx + 1)));
            }
        }

        for(Map.Entry<Integer, PairClass> entry: hashMap.entrySet())
        {
            maxDifference = Math.max(maxDifference, entry.getValue().lastIndex - entry.getValue().firstIndex + 1);
        }


        return (int) maxDifference;
    }
}
