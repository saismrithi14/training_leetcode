import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

class course_schedule_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //first we build the adjacency list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int[] visited = new int[numCourses];

        //We are building the adjacency list
        for(int i = 0; i < prerequisites.length;i++)
        {
            if(map.containsKey(prerequisites[i][1]))
            {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            else{
                List<Integer> new_list = new ArrayList<>();
                new_list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],new_list);
            }
        }


        for(int i = 0; i < numCourses; i++)
        {
            if(dfs(i,set,map,visited))
            {
                return false;
            }
        }

        return true;

    }

    public boolean dfs(int number, LinkedHashSet<Integer> path, HashMap<Integer, List<Integer>> map, int[] visited)
    {
        if(visited[number] == 1)
        {
            return true;
        }

        if(visited[number] == 2)
        {
            return false;
        }
        visited[number] = 1;
        path.add(number);
        if(map.containsKey(number))
        {
            for(Integer n: map.get(number))
            {
                if(dfs(n,path,map,visited))
                {
                    return true;
                }
            }
        }

        visited[number] = 2;
        path.remove(number);
        return false;
    }
}