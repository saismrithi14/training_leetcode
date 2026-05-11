import java.util.*;
public class BinarySubarraysWithSumK {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefix_sum = 0;
        int final_count = 0;
        int count = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length;i++)
        {
            prefix_sum += nums[i];
            if(map.containsKey(prefix_sum - goal))
            {
                final_count += map.get(prefix_sum - goal);
            }

            count = map.getOrDefault(prefix_sum,0);
            map.put(prefix_sum, count + 1);

        }
        return final_count;

    }
}
