class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0;
        int element = Integer.MAX_VALUE;
        while(fast < nums.length)
        {
            if(nums[fast] != element)
            {
                element = nums[fast];
                nums[slow] = nums[fast];
                fast ++;
                slow ++;
            }

            else
            {
                fast ++;
            }
        }

        return slow;
    }
}