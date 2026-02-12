class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0;
        int count = 0, element = Integer.MAX_VALUE;
        while(fast < nums.length)
        {
            if(nums[fast] != element)
            {
                element = nums[fast];
                count = 1;
                nums[slow] = nums[fast];
                fast ++;
                slow ++;
            }

            else
            {
                count ++;
                if(count > 2)
                {
                    fast ++;
                }

                else
                {
                    nums[slow] = nums[fast];
                    fast ++;
                    slow ++;
                }
            }
        }

        return slow;
        
    }
}