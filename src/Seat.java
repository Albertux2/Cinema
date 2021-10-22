public class Seat {
    Location location;
    boolean occupied = false;

    public Seat(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getColumn(){
        return location.getColumn();
    }

    public char getRow(){
        return location.getRow();
    }

    @Override
    public String toString() {
        return "Seat{" +
                ", location=" + location +
                ", occupied=" + occupied +
                '}';
    }
}
