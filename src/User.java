import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Callable;

public class User implements Callable<UserResponse> {
    private Seat occupiedSeat;
    private ArrayList<Request> requests;
    private Pit pit;


    public User(Pit pit) {
        this.pit = pit;
        this.requests = new ArrayList<Request>();
    }

    @Override
    public UserResponse call() {
        Optional<Seat> optionalSeat = Optional.ofNullable(occupiedSeat);
        while (!pit.isPitFull() && !optionalSeat.isPresent()){
            Location locationRequested = generateTillNewLocation('j',30);
            boolean isFree = pit.requestSeat(locationRequested);
            requests.add(new Request(locationRequested,isFree));
            if (isFree){
                this.occupiedSeat = pit.getSeat(locationRequested);
            }
            optionalSeat = Optional.ofNullable(occupiedSeat);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        requests.stream().forEach((r)->System.out.println(Thread.currentThread().getName() + r.showRequest()));
        return new UserResponse(this.requests,this,optionalSeat.orElse(null));
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
