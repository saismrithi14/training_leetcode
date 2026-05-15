public class SortLinkedList{
    private ListNode mergeNodes(ListNode head1, ListNode head2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.val <= temp2.val)
            {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }

            else
            {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 == null)
        {
            temp.next = temp2;
        }

        else
        {
            temp.next = temp1;
        }

        return dummy.next;


    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null)
        {
            return head;
        }

        else
        {
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = null;
            while(fast!=null)
            {

                if(fast.next == null)
                {
                    fast = null;
                }
                else
                {
                    fast = fast.next.next;
                }
                prev = slow;
                slow = slow.next;
            }

            prev.next = null;
            ListNode leftSide = sortList(head);
            ListNode rightSide = sortList(slow);
            return mergeNodes(leftSide, rightSide);
        }


    }
}