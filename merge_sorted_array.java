class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m-1, ptr2 = n-1;
        int write = nums1.length - 1;
        while(ptr1 >=0 && ptr2 >= 0)
        {
            if(nums1[ptr1] >= nums2[ptr2])
            {
                nums1[write] = nums1[ptr1] ;
                ptr1 --;
            }

            else
            {
                nums1[write] = nums2[ptr2];
                ptr2 --;
            }

            write --;
        } 

        if(ptr1 < 0)
        {
            while(ptr2 >= 0)
            {
                nums1[write] = nums2[ptr2];
                write --;
                ptr2 --;
            }
        }

        else
        {
            while(ptr1 >= 0)
            {
                nums1[write] = nums1[ptr1];
                write --;
                ptr1 --;
            }
        }
        
        
    }
}