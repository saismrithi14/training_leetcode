public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;
        while(fast != null)
        {
            if(fast.next == null)
            {
                fast = null;
            }

            else
            {
                fast = fast.next.next;
            }

            slow = slow.next;
            if(fast==slow)
            {
                break;
            }
        }

        if(fast == null) return null;
        while(temp!= fast)
        {
            temp = temp.next;
            fast = fast.next;
        }

        return temp;
    }
}
