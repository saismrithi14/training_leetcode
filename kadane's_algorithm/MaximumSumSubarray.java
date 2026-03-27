class MaximumSumSubarray {
    public int maxSubArray(int[] nums) {
        int global_maximum = nums[0];
        int local_maximum = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            local_maximum = Math.max(local_maximum + nums[i], nums[i]);
            global_maximum = Math.max(local_maximum, global_maximum);
        }

        return global_maximum;
    }
}