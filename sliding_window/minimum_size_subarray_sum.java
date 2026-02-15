class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minimum_length = Integer.MAX_VALUE, left = 0, right = 0;
        int total_sum = 0;
        while(right < nums.length)
        {
            total_sum += nums[right];
            while(total_sum >= target)
            {
                if((right - left + 1) < minimum_length)
                {
                    minimum_length = (right - left + 1);
                }

                total_sum -= nums[left];
                left ++;
            }

            right ++;
        }

        if(minimum_length == Integer.MAX_VALUE)
        {
            return 0;
        }

        return minimum_length;
    }
}