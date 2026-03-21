import java.util.HashMap;
class Node
{
    int val;
    int key;
    public Node next;
    public Node prev;

    public Node(int key, int val)
    {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public Node(){}
}
class LRUCache {
    private int capacity;
    private int total_elements;
    private Node dummyNodeHead;
    private Node dummyNodeTail;
    private HashMap<Integer, Node> nodeHashMap;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.total_elements = 0;
        nodeHashMap = new HashMap<Integer, Node>();
        dummyNodeHead = new Node();
        dummyNodeTail = new Node();
        dummyNodeHead.next = dummyNodeTail;
        dummyNodeTail.prev = dummyNodeHead;
    }

    public int get(int key) {
        if(!nodeHashMap.containsKey(key)){
            return -1;
        }
        Node node = nodeHashMap.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = dummyNodeTail.prev;
        dummyNodeTail.prev = node;
        node.prev.next = node;
        node.next = dummyNodeTail;

        return nodeHashMap.get(key).val;

    }

    public void put(int key, int value) {
        //create a node with the key and value
        if(nodeHashMap.containsKey(key))
        {

            Node node = nodeHashMap.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = dummyNodeTail.prev;
            dummyNodeTail.prev = node;
            node.prev.next = node;
            node.next = dummyNodeTail;
        }
        else
        {
            Node new_node = new Node(key,value);
            if(nodeHashMap.size() == 0)
            {
                dummyNodeTail.prev = new_node;
                new_node.next = dummyNodeTail;
                new_node.prev = dummyNodeHead;
                dummyNodeHead.next = new_node;
                total_elements += 1;
                nodeHashMap.put(key,new_node);
            }
            else{
                new_node.prev = dummyNodeTail.prev;
                dummyNodeTail.prev = new_node;
                new_node.prev.next = new_node;
                new_node.next = dummyNodeTail;
                total_elements += 1;
                nodeHashMap.put(key,new_node);
            }
        }

        if(total_elements > capacity)
        {
            int removing_key = dummyNodeHead.next.key;
            dummyNodeHead.next = dummyNodeHead.next.next;
            dummyNodeHead.next.prev = dummyNodeHead;
            nodeHashMap.remove(removing_key);
            total_elements -= 1;
        }
    }
}