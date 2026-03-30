public class RemoveDuplicates {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null)
            {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;
            int duplicate_value = Integer.MAX_VALUE;
            while(slow != null)
            {
                if(fast == null)
                {

                    if(slow.val != duplicate_value)
                    {
                        temp.next = slow;
                        temp = temp.next;
                        slow.next = null;
                    }
                    slow = fast;
                }
                else if(slow.val != fast.val)
                {

                    if(slow.val != duplicate_value)
                    {
                        temp.next = slow;
                        temp = temp.next;
                        slow.next = null;
                    }
                    slow = fast;
                    fast = fast.next;
                }
                else
                {
                    //System.out.println("Duplicate values detected: " + slow.val + " " + fast.val);
                    duplicate_value = slow.val;
                    while(fast!=null && fast.val == slow.val)
                    {
                        slow = slow.next;
                        fast = fast.next;
                    }
                }
            }

            return dummy.next;

        }
    }

    // Helper: create linked list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for (int num : arr) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return dummy.next;
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        // 🔥 Test cases (important for debugging)

        int[] arr1 = {1, 2, 3, 3, 4, 4, 5, 6, 6};

        ListNode head1 = createList(arr1);
        printList(head1);
        head1 = sol.deleteDuplicates(head1);
        printList(head1);

        System.out.println("------");

    }
}
