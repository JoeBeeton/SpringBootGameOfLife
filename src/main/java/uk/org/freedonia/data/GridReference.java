package uk.org.freedonia.data;



import java.util.Objects;
public class GridReference {

    private int x;
    private int y;

    @Override
    public String toString() {
        return "GridReference{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public GridReference(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridReference that = (GridReference) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
