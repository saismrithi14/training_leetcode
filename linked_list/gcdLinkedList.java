public class gcdLinkedList {
    private int gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;

        while(ptr2 != null)
        {
            int result = 0;
            if(ptr1.val > ptr2.val) result = gcd(ptr1.val, ptr2.val);
            else{
                result = gcd(ptr2.val, ptr1.val);
            }

            ListNode new_node = new ListNode(result);
            ptr1.next = new_node;
            new_node.next = ptr2;
            ptr2 = ptr2.next;
            ptr1 = ptr1.next.next;
        }
        return head;
    }
}
