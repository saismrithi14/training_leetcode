public class longestPalindromicSubstring {
    public String longestPalindrome(String s) {
        //checking for odd length palindrome first
        int max_length = 0;
        String final_string = "";
        for(int i = 0; i < s.length(); i++)
        {
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                int length = (right - left + 1);
                if(length > max_length)
                {
                    max_length = length;
                    final_string = s.substring(left, right + 1);
                }
                left --;
                right++;
            }
        }

        //for even length substrings
        for(int i = 0; i < s.length()-1; i++)
        {
            int left = i;
            int right = i+1;
            while(right < s.length() && left >=0 && s.charAt(left) == s.charAt(right))
            {
                int length = (right - left +1);
                if(length > max_length){
                    max_length = length;
                    final_string = s.substring(left, right + 1);
                }

                left--;
                right ++;
            }
        }

        return final_string;

    }
}