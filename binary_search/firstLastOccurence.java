public firstLastOccurence
{
    public int[] searchRange(int[] nums, int target) {
    int[] final_indices = new int[2];
    int first_occurence = -1;
    int last_occurence = -1;
    //finding the first occurence first
    int fLeft = 0;
    int fRight = nums.length - 1;
    while(fLeft <= fRight)
    {
        int mid = (fLeft + fRight) / 2;
        if(nums[mid] == target)
        {
            first_occurence = mid;
            fRight = mid - 1;
        }

        else if(nums[mid] < target)
        {
            fLeft = mid + 1;
        }

        else
        {
            fRight = mid -1;
        }
    }

    final_indices[0] = first_occurence;

    int sLeft = 0;
    int sRight = nums.length-1;
    while(sLeft <= sRight)
    {
        int mid = (sLeft + sRight)/2;
        if(nums[mid]==target)
        {
            last_occurence = mid;
            sLeft = mid + 1;
        }
        else if(nums[mid] < target)
        {
            sLeft = mid + 1;
        }

        else
        {
            sRight = mid - 1;
        }
    }

    final_indices[1] = last_occurence;
    return final_indices;
}
}