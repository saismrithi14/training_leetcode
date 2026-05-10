public class UniquePaths2
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = 1;
        for(int i = rows-1; i>=0;i--)
        {
            for(int j = cols-1;j>=0;j--)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    dp[i][j] = 0;
                    continue;
                }
                if(i==rows-1 && j==cols-1) continue;
                if(i+1 < rows) dp[i][j] += dp[i+1][j];
                if(j+1 < cols) dp[i][j] += dp[i][j+1];
            }
        }

        return dp[0][0];

    }
}