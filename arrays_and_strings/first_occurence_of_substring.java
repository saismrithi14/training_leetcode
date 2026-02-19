class Solution {
    public int strStr(String haystack, String needle) {
        int start = 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++)
        {
            if(needle.equals(haystack.substring(i, i+ needle.length())))
            {
                start = i;
                return start;
            }
        }

        if(haystack.equals(needle))
        {
            return 0;
        }

        else
        {
            return -1;
        }
        
    }
}