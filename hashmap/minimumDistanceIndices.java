import java.util.*;
import java.util.stream.Collectors;

public class minimumDistanceIndices {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minimum_length = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++)
        {
            List<Integer> key_list = map.getOrDefault(nums[i],new ArrayList<Integer>());
            key_list.add(i);
            map.put(nums[i],key_list);
        }

        Map<Integer, List<Integer>> filteredMap = map.entrySet().stream().filter(entry->entry.getValue().size()>=3).collect(Collectors.toMap(entry->entry.getKey(), entry->entry.getValue()));
        if(filteredMap.size() == 0) return -1;
        for(List<Integer> value: filteredMap.values())
        {
            int left = 0;
            int right = 2;
            while(right < value.size())
            {
                int distance = 2 * (value.get(right) - value.get(left));
                minimum_length = Math.min(distance, minimum_length);
                right++;
                left++;
            }
        }

        return minimum_length;
    }
}
