import java.util.*;
public class spiralMatrixTraversal {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean right = true, down = false, left = false, up = false;
        int total_elements = matrix.length * matrix[0].length;
        int traversed_elements = 0;
        List<Integer> finalList = new ArrayList<>();
        int i = 0, j = 0;
        while(traversed_elements < total_elements)
        {
            traversed_elements +=1;
            finalList.add(matrix[i][j]);
            matrix[i][j] = 101;
            if(right == true)
            {
                if(j+1 >= cols || matrix[i][j+1] == 101)
                {
                    right = false;
                    down = true;
                    i++;
                }
                else
                {
                    j++;
                }
                continue;
            }

            else if(down == true)
            {
                if(i+1 >= rows || matrix[i+1][j] == 101)
                {
                    down = false;
                    left = true;
                    j--;
                }
                else
                {
                    i++;
                }

                continue;
            }

            else if(left == true)
            {
                if(j-1 < 0 || matrix[i][j-1]==101)
                {
                    left = false;
                    up = true;
                    i--;
                }

                else
                {
                    j--;
                }

                continue;
            }

            else
            {
                if(i-1 < 0 || matrix[i-1][j] == 101)
                {
                    up = false;
                    right = true;
                    j++;
                }

                else
                {
                    i--;
                }

                continue;
            }
        }
        return finalList;
    }
}
