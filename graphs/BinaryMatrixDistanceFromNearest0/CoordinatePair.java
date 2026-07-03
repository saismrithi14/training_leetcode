package BinaryMatrixDistanceFromNearest0;

import java.util.Objects;

public class CoordinatePair {
    int row;
    int col;
    public CoordinatePair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int hashCode()
    {
        return Objects.hash(row,col);
    }

    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass() != o.getClass()) return false;
        CoordinatePair obj = (CoordinatePair) o;
        return this.row == obj.row && this.col == obj.col;

    }
}
