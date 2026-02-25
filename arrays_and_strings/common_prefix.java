class common_prefix {
    public String longestCommonPrefix(String[] strs) {
        int minimum_length = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        System.out.println("The final string is: " + sb.toString());
        for(String s: strs)
        {
            if(s.length() < minimum_length)
            {
                minimum_length = s.length();
            }
        }

        System.out.println("Minimum length: " + minimum_length);
        for(int i = 0; i < minimum_length; i++)
        {
            char ch = strs[0].charAt(i);
            for(String s: strs)
            {
                if(s.charAt(i) != ch)
                {
                    return sb.toString();
                }
            }

            sb.append(ch);
        }

        return sb.toString();

    }
}