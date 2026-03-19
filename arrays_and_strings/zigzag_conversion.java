import java.util.*;
import java.util.stream.Collectors;
class zigzag_conversion {
    public String convert(String s, int numRows) {
        if(numRows == 1)
        {
            return s;
        }
        List<List<Character>> list = new ArrayList<>(4);

        int total_numbers = (2 * numRows) - 2;
        for(int i = 0; i < s.length(); i++)
        {
            int index = 0;
            if(i % total_numbers <= Math.ceil(total_numbers/2))
            {
                index = i % total_numbers;
            }
            else
            {
                index = total_numbers - ( i % total_numbers);
            }

            if(index == list.size())
            {
                List<Character> char_list = new ArrayList<>();
                char_list.add(s.charAt(i));
                list.add(char_list);
            }

            else
            {
                list.get(index).add(s.charAt(i));
            }
        }


        String final_result = list.stream().flatMap(x->x.stream()).map(String::valueOf).collect(Collectors.joining());
        return final_result;

    }
}