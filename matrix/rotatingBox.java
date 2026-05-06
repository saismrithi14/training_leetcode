public class rotatingBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length;
        int cols = boxGrid[0].length;
        int emptySpaces = -1;
        for(int i = 0; i < rows; i++)
        {
            emptySpaces = 0;
            for(int j = cols - 1; j >= 0;j--)
            {
                if(boxGrid[i][j] == '.') emptySpaces++;
                else if(boxGrid[i][j] == '#')
                {
                    if(emptySpaces==0) continue;
                    boxGrid[i][j+emptySpaces] = '#';
                    boxGrid[i][j] = '.';
                }
                else
                {
                    emptySpaces = 0;
                }
            }
        }

        char[][] finalGrid = new char[cols][rows];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                finalGrid[j][i] = boxGrid[i][j];
            }
        }

        for(int i = 0; i < cols; i++)
        {
            reverseArray(finalGrid[i]);
        }

        return finalGrid;

    }

    private void reverseArray(char[] array)
    {
        int left = 0;
        int right = array.length - 1;
        while(left <= right)
        {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}

