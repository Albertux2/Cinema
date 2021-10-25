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
            Location locationRequested = Utiles.generateRandomLocation();
            Seat seatRequested = pit.getSeat(locationRequested);
            requests.add(new Request(locationRequested,takeSeat(seatRequested)));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requests.stream().forEach((r)->System.out.println(Thread.currentThread().getName() + r.showRequest()));
    }

    private boolean takeSeat(Seat seat){
        if (seat.isOccupied())
            return false;
        else
        seat.setOccupied(true);
            this.occupiedSeat = seat;
            notifyAll();
            return true;
    }
}
