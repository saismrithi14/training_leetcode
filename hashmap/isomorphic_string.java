import java.util.*;
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        HashSet<Character> values = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        //First check if the strings are equal in length
        if(s.length() != t.length())
        {
            return false;
        }

        else
        {
            for(int i = 0; i < s.length(); i++)
            {
                if(!map.containsKey(s.charAt(i)))
                {
                    if(values.contains(t.charAt(i)))
                    {
                        return false;
                    }

                    else
                    {
                        map.put(s.charAt(i), t.charAt(i));
                        values.add(t.charAt(i));
                    }
                }

                else
                {
                    if(map.get(s.charAt(i)) != t.charAt(i))
                    {
                        return false;
                    }
                }
            }

        }

        return true;

    }
}

public class isomorphic_string
{
    public static void main(String[] args)
    {
        Solution1 s = new Solution1();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String st = sc.nextLine();
        System.out.print("Enter the second string: " );
        String t = sc.nextLine();

        System.out.println("Are the strings isomorphic?: " + s.isIsomorphic(st,t));
    }

}