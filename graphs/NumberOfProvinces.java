import java.util.*;
public class NumberOfProvinces {
    private void BFS(int[][] isConnected, int i, Set<Integer> visitedSet)
    {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visitedSet.add(i);
        while(!queue.isEmpty())
        {
            int idx = queue.poll();
            for(int j = 0; j < isConnected[idx].length;j++)
            {
                if(isConnected[idx][j] == 1 && !visitedSet.contains(j))
                {
                    queue.add(j);
                    visitedSet.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visitedSet = new HashSet<>();
        int count = 0;
        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visitedSet.contains(i))
            {
                BFS(isConnected,i,visitedSet);
                count++;
            }
        }

        return count;
    }
}
