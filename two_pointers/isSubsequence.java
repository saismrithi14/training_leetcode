class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_ptr = 0, t_ptr = 0;
        
        if(s.isEmpty())
        {
            return true;
        }

        else if(!s.isEmpty() && t.isEmpty())
        {
            return false;
        }
        while(t_ptr < t.length() && s_ptr < s.length())
        {

            if(s.charAt(s_ptr) == t.charAt(t_ptr))
            {
                s_ptr ++;
            }

            t_ptr ++;
        }

        return s_ptr == s.length();
     
    }
}