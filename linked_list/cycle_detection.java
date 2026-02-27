class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class cycle_detection {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null)
        {
            if(fast.next == null)
            {
                fast = null;
                break;
            }

            else if(fast.next != null)
            {
                fast = fast.next.next;
                slow = slow.next;
            }

            if(fast==slow)
            {
                return true;
            }
        }

        return false;

    }
}