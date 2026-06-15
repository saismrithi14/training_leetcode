public class DeleteMiddleOfLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while(fast!=null)
        {
            if(fast.next == null)
            {
                fast = null;
                prev.next = slow.next;
                return head;
            }

            else
            {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }
        }
        prev.next = slow.next;
        return head;

    }
}
