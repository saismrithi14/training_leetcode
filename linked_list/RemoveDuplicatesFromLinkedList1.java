public class RemoveDuplicatesFromLinkedList1 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null)
        {
            if(slow.val == fast.val)
            {
                slow.next = fast.next;
                fast = slow.next;
            }

            else
            {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return head;
    }
}
