public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if((mid-1 < 0 || nums[mid] != nums[mid-1]) && (mid+1 == nums.length || nums[mid] != nums[mid+1]))return nums[mid];

            int leftSize = 0;
            if(mid - 1 >= 0 && nums[mid] != nums[mid-1])
            {
                leftSize = mid;
            }

            else
            {
                leftSize = mid - 1;
            }

            if(leftSize % 2 == 0)
            {
                left = mid + 1;
            }

            else
            {
                right = mid - 1;
            }
        }

        return 0;

    }
}