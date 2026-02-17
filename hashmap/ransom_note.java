class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransom = new HashMap<>();
        HashMap<Character, Integer> mag = new HashMap<>();

        //Populating both the hashmap: First is the ransomNote
        for(int i = 0; i < ransomNote.length(); i++)
        {
            if(ransom.containsKey(ransomNote.charAt(i)))
            {
                int count = ransom.get(ransomNote.charAt(i));
                ransom.put(ransomNote.charAt(i), count + 1);
            }

            else
            {
                ransom.put(ransomNote.charAt(i), 1);
            }
        }

        // populating the magazine hashmap
        for(int i = 0; i < magazine.length(); i++)
        {
            if(mag.containsKey(magazine.charAt(i)))
            {
                int count = mag.get(magazine.charAt(i));
                mag.put(magazine.charAt(i), count + 1);
            }

            else
            {
                mag.put(magazine.charAt(i),1);
            }
        }

        //Now we need to iterate over the ransomNote
        for(Map.Entry<Character, Integer> entry: ransom.entrySet())
        {
            if(!mag.containsKey(entry.getKey()))
            {
                return false;
            }

            else if(mag.get(entry.getKey()) < ransom.get(entry.getKey()))
            {
                return false;
            }
        }

        return true;
        
    }
}