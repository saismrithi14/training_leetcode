
public class add_2_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null || l2 != null)
        {
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            ListNode new_node = new ListNode(digit);
            temp.next = new_node;
            temp = new_node;
            carry = sum / 10;

            if(l1!=null)
            {
                l1 = l1.next;
            }

            if(l2!=null)
            {
                l2 = l2.next;
            }
        }

        if(carry == 1)
        {
            ListNode final_node = new ListNode(1);
            temp.next = final_node;
        }

        return dummy.next;

    }
}