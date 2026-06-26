public class SwapLinkedListPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        boolean isEven = false;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(p1 != null && p2 != null)
        {
            ListNode n = p2.next;
            temp.next = p2;
            temp = temp.next;
            temp.next = null;
            temp.next = p1;
            temp = temp.next;
            temp.next = null;
            p1 = n;
            if(p1 == null)
            {
                isEven = true;
                break;
            }

            else if(p1.next == null)
            {
                isEven = false;
                break;
            }

            else
            {
                p2 = p1.next;
            }
        }

        if(isEven == false)
        {
            temp.next = p1;
        }

        return dummy.next;
    }
}
