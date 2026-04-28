public class SubarrayOfSumK
{
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total_count = 0;
        int prefix_sum = 0;
        map.put(0,1);
        for(int n: nums)
        {
            prefix_sum += n;
            int count = map.getOrDefault(prefix_sum,0);

            if(map.containsKey(prefix_sum -k))
            {
                total_count += map.get(prefix_sum - k);
            }

            map.put(prefix_sum, count+1);

        }

        return total_count;
    }
}