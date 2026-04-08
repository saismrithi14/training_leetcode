public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode lessTemp = less;
        ListNode moreTemp = more;
        ListNode ptr = head;
        ListNode n = null;

        while(ptr != null)
        {
            if(ptr.val < x)
            {
                lessTemp.next = ptr;
                n = ptr.next;
                ptr.next = null;
                lessTemp = lessTemp.next;
                ptr = n;
            }

            else
            {
                moreTemp.next = ptr;
                n = ptr.next;
                ptr.next = null;
                moreTemp = moreTemp.next;
                ptr = n;
            }
        }

        lessTemp.next = more.next;
        return less.next;
    }
}
