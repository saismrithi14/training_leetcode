package BinaryMatrixDistanceFromNearest0;
import java.util.*;
public class BinaryMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Deque<CoordinatePair> q = new ArrayDeque<>();
        Set<CoordinatePair> set = new HashSet<>();
        int[][] ans = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(mat[i][j] == 0)
                {
                    CoordinatePair cp = new CoordinatePair(i,j);
                    q.addLast(cp);
                    set.add(cp);
                    ans[i][j] = 0;
                }
            }
        }

        //Now we need regular BFS
        while(!q.isEmpty())
        {
            CoordinatePair cp = q.removeFirst();
            int row = cp.row;
            int col = cp.col;
            int dist = ans[row][col];

            int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
            for(int[] d: dirs)
            {
                int nr = row + d[0];
                int nc = col + d[1];
                if(nr < 0 || nc < 0 || nr == mat.length || nc == mat[0].length || set.contains(new CoordinatePair(nr,nc)))
                {
                    continue;
                }

                CoordinatePair ncp = new CoordinatePair(nr,nc);
                set.add(ncp);
                q.addLast(ncp);
                ans[nr][nc] = dist + 1;

            }

        }

        return ans;

    }
}
