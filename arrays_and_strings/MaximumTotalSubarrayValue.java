public class MaximumTotalSubarrayValue {
    public long maxTotalValue(int[] nums, int k) {
        Long minimum = Long.MAX_VALUE;
        Long maximum = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            minimum = Math.min(minimum,nums[i]);
            maximum = Math.max(maximum, nums[i]);
        }

        return (maximum - minimum) * k;

    }
}
