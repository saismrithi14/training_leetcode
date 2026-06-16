public class ProcessStringWithSpecialOperations {
    public String processStr(String s) {
        StringBuilder cur = new StringBuilder();
        StringBuilder rev = new StringBuilder();
        for(int i = 0; i < s.length();i++)
        {
            if(s.charAt(i) == '*' && cur.length() != 0)
            {
                cur.deleteCharAt(cur.length()- 1);
                rev.deleteCharAt(0);
            }

            else if(s.charAt(i) == '#')
            {
                cur.append(cur.toString());
                rev.insert(0,rev.toString());
            }

            else if(s.charAt(i) == '%')
            {
                StringBuilder temp = cur;
                cur = rev;
                rev = temp;
            }

            else if(Character.isLetter(s.charAt(i)))
            {
                cur.append(Character.toString(s.charAt(i)));
                rev.insert(0,Character.toString(s.charAt(i)));
            }
        }
        return cur.toString();
    }
}