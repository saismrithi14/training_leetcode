import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    private void traversal(int i, Map<Character, List<String>> map, String digits, List<String> final_list, StringBuilder sb)
    {
        if(i==digits.length())
        {
            final_list.add(sb.toString());
            return;
        }

        else
        {
            for(String element: map.get(digits.charAt(i)))
            {
                sb.append(element);
                traversal(i+1,map,digits,final_list,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2',List.of("a","b","c"));
        map.put('3',List.of("d","e","f"));
        map.put('4',List.of("g","h","i"));
        map.put('5',List.of("j","k","l"));
        map.put('6',List.of("m","n","o"));
        map.put('7',List.of("p","q","r","s"));
        map.put('8',List.of("t","u","v"));
        map.put('9',List.of("w","x","y","z"));

        List<String> final_list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        traversal(0,map,digits,final_list, sb);
        return final_list;
    }
}
