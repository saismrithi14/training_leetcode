class Solution {
    public boolean isPalindrome(String s) {
        String modified_string = "";
        for(char n : s.toCharArray())
        {
            if(Character.isLetterOrDigit(n))
            {
                if(n >= 'A' && n <= 'Z' || n >= 'a' && n <= 'z')
                {
                    Character lower = Character.toLowerCase(n);
                    modified_string += lower;
                }

                else
                {
                    modified_string += n;
                }
            }
        }

        //System.out.println("Modified string is now: " + modified_string);
        int left = 0, right = modified_string.length() - 1;
        while(left <= right)
        {
            //System.out.println("Left: " + modified_string.charAt(left));
            //System.out.println("Right: " + modified_string.charAt(right));
            if (modified_string.charAt(left) != modified_string.charAt(right))
            {
                return false;
            }

            left ++;
            right --;
        }

        return true;
        
    }
}