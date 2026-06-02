import java.util.*;
public class courseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < prerequisites.length; i++)
        {
            indegree[prerequisites[i][0]] += 1;
            List<Integer> list = map.getOrDefault(prerequisites[i][1],new ArrayList<>());
            list.add(prerequisites[i][0]);
            map.put(prerequisites[i][1],list);
        }

        for(int i = 0; i < numCourses; i++)
        {
            if(!map.containsKey(i))
            {
                map.put(i,new ArrayList<>());
            }
        }

        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0) queue.addLast(i);
        }

        int[] finalOrder = new int[numCourses];
        int j = 0;
        int total_elements = 0;
        while(!queue.isEmpty())
        {
            int value = queue.removeFirst();
            finalOrder[j] = value;
            j++;
            total_elements += 1;
            for(Integer element: map.get(value))
            {
                indegree[element] -= 1;
                if(indegree[element] == 0)
                {
                    queue.addLast(element);
                }
            }
        }

        if(total_elements == numCourses) return finalOrder;
        return new int[0];
    }
}
