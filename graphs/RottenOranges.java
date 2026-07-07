
import java.util.ArrayDeque;
import java.util.Deque;

class Triplet{
    int row;
    int col;
    int time;
    public Triplet(int row, int col, int time)
    {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int final_result = 0;

        Deque<Triplet> q = new ArrayDeque<>();
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[0].length; j++)
            {
                if(grid[i][j]==2)
                {
                    q.addLast(new Triplet(i,j,0));
                }
            }
        }

        while(!q.isEmpty())
        {
            Triplet trip = q.removeFirst();
            int row = trip.row;
            int col = trip.col;
            int time = trip.time;

            int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] d: dir)
            {
                int nr = row + d[0];
                int nc = col + d[1];

                if(nr < 0 || nr == grid.length || nc < 0 || nc == grid[0].length || grid[nr][nc] == 2 || grid[nr][nc] == 0)
                {
                    continue;
                }

                else
                {
                    final_result = Math.max(time+1,final_result);
                    q.addLast(new Triplet(nr,nc,time+1));
                    grid[nr][nc] = 2;
                }

            }

        }

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j< grid[0].length; j++)
            {
                if(grid[i][j] == 1) return -1;
            }
        }
        return final_result;
    }
}
