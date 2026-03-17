
import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        Deque<Node> q = new ArrayDeque();
        if(node == null)
        {
            return null;
        }
        q.add(node);
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            if(!map.containsKey(curr))
            {
                Node new_node = new Node(curr.val);
                map.put(curr, new_node);
            }

            for(Node n: curr.neighbors)
            {
                if(!map.containsKey(n))
                {
                    map.put(n,new Node(n.val));
                    q.add(n);
                }

                map.get(curr).neighbors.add(map.get(n));
            }
        }

        return map.get(node);

    }
}
