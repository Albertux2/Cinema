public class Seat {

    boolean occupied = false;

    public Seat() {
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public synchronized boolean takeSeat() {
        if (isOccupied()) {
            return false;
        } else {
            setOccupied(true);
            return true;
        }
    }
}
