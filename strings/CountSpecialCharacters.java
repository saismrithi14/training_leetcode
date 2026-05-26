public class CountSpecialCharacters {
    public int numberOfSpecialChars(String word) {
        Set<Character> charSet = new HashSet<>();
        int count = 0;
        for(int i = 0; i < word.length(); i++)
        {
            charSet.add(word.charAt(i));
        }

        for(Character ch: charSet)
        {
            if(Character.isLowerCase(ch))
            {
                if(charSet.contains(Character.toUpperCase(ch))) count++;
            }
        }

        return count;
    }
}