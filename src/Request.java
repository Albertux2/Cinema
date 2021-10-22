public class Request {
    Seat requestedSeat;
    boolean accepted;

    public Request(Seat requested, boolean accepted) {
        this.requestedSeat = requested;
        this.accepted = accepted;
    }

    public void showRequest(){
        System.out.println("Requested seat at "+ requestedSeat.getColumn()+" : "+ requestedSeat.getRow()+", accepted? "+accepted);
    }

    public Seat getRequestedSeat() {
        return requestedSeat;
    }

    public boolean isAccepted() {
        return accepted;
    }

}
