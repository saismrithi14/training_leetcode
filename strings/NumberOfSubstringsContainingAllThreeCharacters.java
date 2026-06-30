public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        Map<String,Integer> map = new HashMap<>();
        int j = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++)
        {
            while(j < s.length() && !(map.containsKey("a") && map.containsKey("b") && map.containsKey("c")))
            {
                map.put(Character.toString(s.charAt(j)), map.getOrDefault(Character.toString(s.charAt(j)),0) + 1);
                j++;
            }

            if(map.containsKey("a") && map.containsKey("b") && map.containsKey("c"))
            {
                result += (s.length() - j + 1);
            }

            map.put(Character.toString(s.charAt(i)),map.get(Character.toString(s.charAt(i))) - 1);
            if(map.get(Character.toString(s.charAt(i))) == 0)
            {
                map.remove(Character.toString(s.charAt(i)));
            }
        }

        return result;
    }
}