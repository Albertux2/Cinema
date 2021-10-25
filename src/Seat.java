public class Seat {

    boolean occupied = false;

    public Seat() {
    }

    public boolean isOccupied() {
        return occupied;
    }

    public synchronized void setOccupied(boolean occupied) {
        this.occupied = occupied;
        notifyAll();
    }
}
