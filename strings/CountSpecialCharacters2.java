public class CountSpecialCharacters2 {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < word.length();i++)
        {
            Character ch = word.charAt(i);
            if(!map.containsKey(ch))
            {
                map.put((ch),i);
            }

            else{
                if(Character.isUpperCase(ch))
                {
                    if(map.get(ch) < i)
                    {
                        continue;
                    }
                }
                else
                {
                    if(Character.isLowerCase(ch))
                    {
                        if(map.get(ch) < i)
                        {
                            map.put(ch,i);
                        }
                    }
                }
            }
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            if(Character.isUpperCase(entry.getKey()))
            {
                if(!map.containsKey(Character.toLowerCase(entry.getKey()))) continue;

                else{
                    if(map.get(entry.getKey()) > map.get(Character.toLowerCase(entry.getKey()))) count ++;
                }
            }
        }

        return count;

    }
}