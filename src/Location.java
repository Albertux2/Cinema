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
}
