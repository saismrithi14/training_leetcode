public class MinimumPathSum
{
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = grid[rows-1][cols-1];

        for(int i = rows - 1; i >=0; i--)
        {
            for(int j = cols-1; j >= 0;j--)
            {
                if(i==rows-1 && j==cols-1)
                {
                    continue;
                }

                dp[i][j] = grid[i][j] + Math.min(
                        (i + 1 < rows ? dp[i + 1][j] : Integer.MAX_VALUE),
                        (j + 1 < cols ? dp[i][j + 1] : Integer.MAX_VALUE)
                );
            }

        }

        return dp[0][0];
    }
}