import java.util.*;

public class IntegerToRoman {
    public String intToRoman(int num) {
        List<Map.Entry<Integer, String>> list = List.of(
                Map.entry(1000,"M"),
                Map.entry(900,"CM"),
                Map.entry(500,"D"),
                Map.entry(400,"CD"),
                Map.entry(100,"C"),
                Map.entry(90,"XC"),
                Map.entry(50,"L"),
                Map.entry(40,"XL"),
                Map.entry(10,"X"),
                Map.entry(9,"IX"),
                Map.entry(5,"V"),
                Map.entry(4,"IV"),
                Map.entry(1,"I")
        );
        int ptr = 0;
        StringBuilder sb = new StringBuilder();
        while(num!=0)
        {
            if(list.get(ptr).getKey() <= num)
            {
                sb.append(list.get(ptr).getValue());
                num = num - list.get(ptr).getKey();
            }

            else
            {
                ptr ++;
            }
        }

        return sb.toString();
    }
}