class Solution {
    public int lengthOfLongestSubstring(String s) {
        int substring_length = 0;
        HashMap<Character, Integer> frequency = new HashMap<>();
        int left = 0, right = 0;
        while(right < s.length())
        {
        
            if(!frequency.containsKey(s.charAt(right)))
            {
                frequency.put(s.charAt(right), 1);
                if((right - left + 1) > substring_length)
                {
                    substring_length = (right - left + 1);
                }

                right ++;


            }

            else
            {
               
                while(frequency.containsKey(s.charAt(right)))
                {
                    
                    if(frequency.get(s.charAt(left)) > 1)
                    {
                        int count = frequency.get(s.charAt(left));
                        frequency.put(s.charAt(left), count - 1);
                    }

                    else
                    {
                        frequency.remove(s.charAt(left));
                    }
                    

                    left ++;
                    
                }

                if((right - left + 1) > substring_length)
                {
                    substring_length = (right - left + 1);
                }

                frequency.put(s.charAt(right), 1);
                right ++;
            }
 
        }

        return substring_length;

    }
}