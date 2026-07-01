class Solution {
    public int majorityElement(int[] nums) {
        LinkedHashMap<Integer, Integer> frequency = new LinkedHashMap<>();
        int maximum_value = 0, key = 0;
        int threshold = (int) Math.ceil(nums.length / 2);
        for(int n: nums)
        {
            if(frequency.containsKey(n))
            {
                int count = frequency.get(n);
                frequency.put(n,count + 1);
            }

            else
            {
                frequency.put(n,1);
            }
        }

        //Iterating through the hashmap to get the key with maximum frequency
        for(Map.Entry<Integer, Integer> entry : frequency.entrySet())
        {
            if(entry.getValue() >= threshold)
            {
                if(entry.getValue() > maximum_value)
                {
                    key = entry.getKey();
                    maximum_value = entry.getValue();
                }
            }
        }

        return key;
        
        
    }
}