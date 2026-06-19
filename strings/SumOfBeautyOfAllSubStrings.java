public class SumOfBeautyOfAllSubStrings {
    public int beautySum(String s) {
        int totalSum = 0;
        int max_value = 0;
        int min_value = Integer.MAX_VALUE;

        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                int count = freqMap.getOrDefault(s.charAt(j),0);
                freqMap.put(s.charAt(j), count+1);
                max_value = Math.max(max_value, freqMap.get(s.charAt(j)));

                for(Map.Entry<Character,Integer>entry:freqMap.entrySet())
                {
                    if(entry.getValue() < min_value) min_value = entry.getValue();
                }

                totalSum += (max_value - min_value);

                min_value = Integer.MAX_VALUE;
            }

            freqMap.clear();
            max_value = 0;
            min_value = Integer.MAX_VALUE;
        }

        return totalSum;
    }
}