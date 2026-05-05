public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }

        k = k % count;
        if(k==0) return head;
        ListNode slow = head;
        ListNode fast = head;
        int jumps = 0;
        ListNode firstLast = null;
        ListNode secondLast = null;
        while(jumps < k)
        {
            fast = fast.next;
            jumps++;
        }

        while(fast!=null)
        {
            if(fast.next == null)
            {
                firstLast = slow;
                secondLast = fast;
            }

            slow = slow.next;
            fast = fast.next;
        }

        firstLast.next = null;
        secondLast.next = head;
        return slow;


    }
}
