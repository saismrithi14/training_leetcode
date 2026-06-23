import java.util.*;

class Pairs{
    int x;
    int y;
    public Pairs(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int hashCode()
    {
        return Objects.hash(x,y);
    }

    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Pairs obj = (Pairs) o;
        return obj.x == this.x && obj.y == this.y;
    }
}


public class SurroundedRegions {
    private void dfs(char[][] grid, int x, int y, Set<Pairs> pairSet)
    {
        if(x < 0 || x == grid.length || y < 0 || y == grid[0].length) return;
        if(grid[x][y] == 'X') return;
        if(pairSet.contains(new Pair(x,y))) return;

        pairSet.add(new Pairs(x,y));
        grid[x][y] = 'S';
        dfs(grid,x-1,y,pairSet);
        dfs(grid, x,y+1,pairSet);
        dfs(grid,x+1,y,pairSet);
        dfs(grid,x,y-1,pairSet);
    }
    public void solve(char[][] board) {
        Set<Pairs> pairSet = new HashSet<>();
        int i = 0;
        for(int l = 0; l < board[0].length; l++)
        {
            if(board[i][l] == 'O' && !pairSet.contains(new Pair(i,l)))
            {
                dfs(board,i,l,pairSet);
            }
        }

        int j = 0;
        for(int k = 0; k < board.length; k++)
        {
            if(board[k][j] == 'O' && !pairSet.contains(new Pair(k,j)))
            {
                dfs(board,k,j,pairSet);
            }
        }

        i = board.length - 1;
        for(int m = 0; m < board[0].length; m++)
        {
            if(board[i][m] == 'O' && !pairSet.contains(new Pair(i,m)))
            {
                dfs(board,i,m,pairSet);
            }
        }

        j = board[0].length - 1;
        for(int n = 0; n < board.length; n++)
        {
            if(board[n][j] == 'O' && !pairSet.contains(new Pair(n,j)))
            {
                dfs(board,n,j,pairSet);
            }
        }

        for(int a = 0; a < board.length; a++)
        {
            for(int b = 0; b < board[0].length; b++)
            {
                if(board[a][b] == 'S') board[a][b] = 'O';
                else if(board[a][b] == 'O') board[a][b] = 'X';
            }
        }

    }


    public static void main(String[] args) {
    SurroundedRegions sr = new SurroundedRegions();
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        sr.solve(board);

        // print result
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
