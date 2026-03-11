class number_palindrome {
    public boolean isPalindrome(int x) {
        if(x < 0)
        {
            return false;
        }

        int reversed_number = 0;
        int number = x;
        while(number != 0)
        {
            int digit = number % 10;
            reversed_number = reversed_number * 10 + digit;
            number = number / 10;
        }

        return reversed_number == x;

    }
}