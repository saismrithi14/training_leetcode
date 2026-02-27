import java.util.HashSet;
class Pair
{
    private int x;
    private int y;

    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        if(p.x == this.x && p.y==y)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return 41*(x+y);
    }

    @Override
    public String toString()
    {
        return "x value:" + x + " and y value: " + y;
    }
}
class SolutionIslands {

    private HashSet<Pair> pairSet = new HashSet<>();
    private int rows;
    private int cols;

    private void dfs(int row, int col, char[][] grid)
    {
        if(row < 0 || row >= rows || col < 0 || col >= cols)
        {
            return;
        }

        if(grid[row][col] == '0')
        {
            return;
        }

        if(grid[row][col] == '1' && pairSet.contains(new Pair(row, col)))
        {
            return;
        }


        pairSet.add(new Pair(row, col));
        dfs(row+1, col,grid);
        dfs(row-1, col,grid);
        dfs(row, col+1,grid);
        dfs(row, col - 1,grid);

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == '1' && !pairSet.contains(new Pair(i,j)))
                {

                    dfs(i,j,grid);
                    count += 1;
                }
            }
        }

        return count;

    }
}

public class number_of_islands {

    public static void main(String[] args) {

        SolutionIslands sol = new SolutionIslands();

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        int result = sol.numIslands(grid);

        System.out.println("Number of islands: " + result);
    }
}