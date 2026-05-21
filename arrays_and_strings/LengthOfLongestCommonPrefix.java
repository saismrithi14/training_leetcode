import java.util.*;
public class LengthOfLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int largestCommonPrefix = 0, digitCount = 0;
        Set<Integer> prefixSet = new HashSet<>();
        for(int i = 0;i < arr1.length;i++)
        {
            int element = arr1[i];
            while(element != 0)
            {
                prefixSet.add(element);
                element = element / 10;
            }
        }

        for(int i = 0; i < arr2.length; i++)
        {
            int element = arr2[i];
            while(element != 0)
            {
                if(prefixSet.contains(element))
                {
                    if(element > largestCommonPrefix)
                    {
                        largestCommonPrefix = element;
                    }
                }

                element = element / 10;
            }
        }

        while(largestCommonPrefix != 0)
        {
            digitCount++;
            largestCommonPrefix = largestCommonPrefix / 10;
        }

        return digitCount;

    }

}
