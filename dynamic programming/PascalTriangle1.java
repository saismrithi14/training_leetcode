public class PascalTriangle1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(List.of(1));
        for(int i = 1; i < numRows; i++)
        {
            List<Integer> subList = new ArrayList<>();
            int j = 0;
            while(j < finalList.get(i-1).size())
            {
                if(j-1 < 0)
                {
                    subList.add(finalList.get(i-1).get(j) + 0);
                }

                else
                {
                    subList.add(finalList.get(i-1).get(j) + finalList.get(i-1).get(j-1));
                }
                j++;
            }

            if(j == finalList.get(i-1).size())
            {
                subList.add(finalList.get(i-1).get(j-1) + 0);
            }

            finalList.add(subList);
        }

        return finalList;

    }
}