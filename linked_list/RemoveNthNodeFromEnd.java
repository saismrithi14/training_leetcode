public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode slow = head;
        ListNode node = head;
        int count = 0;
        while(count < n)
        {
            node = node.next;
            count ++;
        }

        while(node != null && node.next != null)
        {
            slow = slow.next;
            node = node.next;
        }

        if(node == null)
        {
            head = head.next;
        }
        else
        {
            slow.next = slow.next.next;
        }
        return head;


    }
}
