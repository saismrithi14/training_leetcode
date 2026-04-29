import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maximum_length = 0;
        Set<Integer> set = new HashSet<>();
        for(int number: nums)
        {
            set.add(number);
        }
        for(int element: set)
        {
            int current_length = 0;
            if(set.contains(element - 1)) continue;
            int value = element;
            while(set.contains(value))
            {
                current_length+=1;
                maximum_length = Math.max(current_length, maximum_length);
                value++;
            }
        }

        return maximum_length;

    }
}
