import java.util.HashMap;
class anagrams {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        //s hashmap
        for(int i = 0; i < s.length(); i++)
        {
            int count = sMap.getOrDefault(s.charAt(i), 0);
            sMap.put(s.charAt(i), count + 1);
        }

        //t hashmap
        for(int i = 0; i < t.length(); i++)
        {
            int count = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), count + 1);
        }

        return sMap.equals(tMap);


    }
}