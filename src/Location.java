import java.util.Objects;

public class Location {
    private char row;
    private int column;

    public Location(char row, int column) {
        this.row = row;
        this.column = column;
    }

    public Location(char row) {
        this.row = row;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getRow() == location.getRow() && getColumn() == location.getColumn();
    }
}
