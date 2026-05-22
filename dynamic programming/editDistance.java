public class editDistance {
    public int minDistance(String word1, String word2) {
        int rows = word1.length() + 1;
        int cols = word2.length() + 1;
        int[][] dp = new int[rows][cols];
        for(int i = rows-1; i >= 0; i--)
        {
            for(int j = cols-1; j >=0;j--)
            {
                if(i==rows-1 && j == cols - 1) dp[i][j] = 0;

                else if(i==rows-1) dp[i][j] = dp[i][j+1] + 1;
                else if(j==cols-1) dp[i][j] = dp[i+1][j] + 1;
                else if(word1.charAt(i) == word2.charAt(j))
                {
                    dp[i][j] = dp[i+1][j+1];
                }

                else{
                    int right = j+1 < cols ? dp[i][j+1]: Integer.MAX_VALUE;
                    int down = i+1 < rows? dp[i+1][j]: Integer.MAX_VALUE;
                    int diagonal = (i+1 < rows&& j+1 < cols)?dp[i+1][j+1]: Integer.MAX_VALUE;
                    dp[i][j] = Math.min(right,Math.min(down,diagonal)) + 1;
                }
            }
        }
        return dp[0][0];
    }
}