import java.util.*;
class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer {
    public Node1 copyRandomList(Node1 head) {
        //We will need two passes
        //First pass, to create a node
        Map<Node1, Node1> map = new LinkedHashMap<>();
        Node1 temp = head;
        while(temp!=null)
        {
            Node1 new_node = new Node1(temp.val);
            map.put(temp, new_node);
            temp = temp.next;
        }

        //second pass, now we set all the pointers:
        map.forEach((key,value)->{
            value.next = map.get(key.next);
            value.random = map.get(key.random);
        });

        return map.get(head);
    }
}
