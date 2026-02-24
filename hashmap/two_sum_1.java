import java.util.*;
public class two_sum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] final_result = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                final_result[0] = map.get(target- nums[i]);
                final_result[1] = i;
                return final_result;
            }

            else
            {
                map.put(nums[i], i);
            }
        }

        return final_result;

    }
}