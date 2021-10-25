import java.util.ArrayList;

public class User implements Runnable{
    Seat occupiedSeat;
    ArrayList<Request> requests;
    Pit pit;


    public User(Pit pit) {
        this.pit = pit;
        this.requests = new ArrayList<Request>();
    }

    @Override
    public void run() {
        while (!pit.isPitFull() && occupiedSeat == null){
            Location locationRequested = generateTillNewLocation('j',30);
            Seat seatRequested = pit.getSeat(locationRequested);
            boolean isFree = seatRequested.takeSeat();
            requests.add(new Request(locationRequested,isFree));
            if (isFree){
                this.occupiedSeat = seatRequested;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        requests.stream().forEach((r)->System.out.println(Thread.currentThread().getName() + r.showRequest()));
    }

    private Location generateTillNewLocation(char lastLetter, int cap){
        boolean newLocation = true;
        Location locationRequested = null;
        do{
            locationRequested = Utiles.generateRandomLocation(lastLetter,cap);
            Location finalLocationRequested = locationRequested;
            newLocation = requests.stream().anyMatch((r)->{return r.getRequestedLocation().equals(finalLocationRequested);});
        }while(newLocation);
        return locationRequested;
    }

    public Seat getOccupiedSeat() {
        return occupiedSeat;
    }
}
