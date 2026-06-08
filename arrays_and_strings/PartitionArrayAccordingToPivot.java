import java.util.*;
public class PartitionArrayAccordingToPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThan = new ArrayList<>();
        List<Integer> greaterThan = new ArrayList<>();
        int pivotCount = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < pivot) lessThan.add(nums[i]);
            else if(nums[i] > pivot) greaterThan.add(nums[i]);
            else
            {
                pivotCount +=1;
            }
        }

        int j = 0;
        for(int i = 0; i < lessThan.size(); i++)
        {
            nums[j] = lessThan.get(i);
            j++;
        }

        for(int i = 0; i < pivotCount; i++)
        {
            nums[j] = pivot;
            j++;
        }

        for(int i = 0; i < greaterThan.size(); i++)
        {
            nums[j] = greaterThan.get(i);
            j++;
        }

        return nums;

    }
}
