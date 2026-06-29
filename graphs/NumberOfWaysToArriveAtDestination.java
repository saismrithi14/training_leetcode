import java.util.*;
class Two
{
    int dest;
    long time;
    public Two(int dest, long time)
    {
        this.dest = dest;
        this.time = time;
    }
}

class Node1
{
    long distance;
    int node;
    public Node1(long distance, int node)
    {
        this.distance = distance;
        this.node = node;
    }
}
public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        Queue<Node1> pq = new PriorityQueue<>((a,b)-> Long.compare(a.distance, b.distance));
        pq.offer(new Node1(0,0));
        Map<Integer, List<Two>> map = new HashMap<>();
        int mod = 1000000007;

        if(roads.length == 0)
        {
            return 1;
        }

        //Now first we will need to build the adjacency list
        for(int i = 0; i < roads.length; i++)
        {

            int source = roads[i][0];
            int dest = roads[i][1];
            int time = roads[i][2];

            List<Two> subList = map.getOrDefault(source, new ArrayList<Two>());
            subList.add(new Two(dest,(long)time));
            map.put(source, subList);

            List<Two> secondSubList = map.getOrDefault(dest,new ArrayList<Two>());
            secondSubList.add(new Two(source,(long)time));
            map.put(dest,secondSubList);
        }


        //We will need to count the number of ways and find out the shortest distance to reach each node
        long[] ways = new long[n];
        ways[0] = 1;
        long[] dist = new long[n];

        for(int i = 1; i < n; i++)
        {
            dist[i] = Long.MAX_VALUE;
        }

        while(!pq.isEmpty())
        {
            Node1 temp = pq.poll();
            long nodeDistance = temp.distance;
            int nodeVal = temp.node;
            for(Two two: map.get(nodeVal))
            {
                int newDest = two.dest;
                long time = two.time;
                if(nodeDistance + time < dist[newDest])
                {
                    dist[newDest] = nodeDistance + time;
                    ways[newDest] = ways[nodeVal];
                    pq.offer(new Node1(dist[newDest],newDest));
                }

                else if(nodeDistance + time == dist[newDest])
                {
                    ways[newDest] = (ways[newDest] + ways[nodeVal]) % mod;
                }
            }
        }

        return (int) ways[n-1] % mod;
    }
}
