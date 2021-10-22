import java.util.HashMap;

public class Pit {
    HashMap<Location,Seat> seats = new HashMap<>();

    public Pit() {
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


}
