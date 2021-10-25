import java.util.HashMap;

public class Pit {
    HashMap<Location,Seat> seats = new HashMap<>();

    public Pit() {
        fillPit(2,5);
    }

    public HashMap<Location, Seat> getSeats() {
        return seats;
    }

    public void addSeat(Location location, Seat seat){
        seats.put(location,seat);
    }

    public Seat getSeat(Location location){
        return seats.get(location);
    }

    public boolean isPitFull(){
        boolean full = seats.values().parallelStream().allMatch(Seat::isOccupied);
        return full;
    }

    private void fillPit(int desiredRows, int desiredColumns) {
        for (int i = 0; i < desiredRows; i++) {
            char row = (char) ('a' + i);
            for (int j = 0; j < desiredColumns; j++) {
                Location actualLocation = new Location(row, j);
                Seat mySeat = new Seat();
                addSeat(actualLocation, mySeat);
            }
        }
    }


}
