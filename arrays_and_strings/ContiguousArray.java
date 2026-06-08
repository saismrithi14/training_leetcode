import java.util.*;
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max_length = 0;
        int zeroCount = 0;
        int oneCount = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length;i++)
        {
            if(nums[i] == 0) zeroCount++;
            else{
                oneCount++;
            }

            if(map.containsKey(oneCount - zeroCount))
            {
                max_length = Math.max(max_length, i-map.get(oneCount-zeroCount));
            }

            else
            {
                map.put((oneCount - zeroCount),i);
            }
        }

        return max_length;
    }
}
