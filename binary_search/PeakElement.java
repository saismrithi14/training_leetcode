public class PeakElement
{
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(left == right)
            {
                return left;
            }

            if((right - left + 1) == 2)
            {
                return nums[left] > nums[right]? left:right;
            }

            else
            {
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                {
                    return mid;
                }

                else if(nums[mid] < nums[mid+1])
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid -1;
                }
            }
        }
        return left;
    }
}