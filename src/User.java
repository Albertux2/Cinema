import java.util.ArrayList;

public class User extends Thread{
    Seat occupiedSeat;
    ArrayList<Request> requests;
    Cinema cinema = Cinema.getInstance();


    public User() {
        this.requests = new ArrayList<Request>();
    }

    @Override
    public void run() {
        cinema.fillPit(1,2);
        Pit cinemaPit = cinema.getPit();
        super.run();
        while (!cinemaPit.isPitFull() && occupiedSeat == null){
            Seat seatRequested = new Seat(Utiles.generateRandomLocation());
            requests.add(new Request(seatRequested,takeSeat(seatRequested)));
        }
        requests.stream().forEach(Request::showRequest);
    }

    private boolean takeSeat(Seat seat){
        if (seat.isOccupied())
            return false;
        else
            seat.setOccupied(true);
            this.occupiedSeat = seat;
            return true;
    }
}
