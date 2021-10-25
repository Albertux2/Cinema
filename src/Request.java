public class Request {
    Location requestedSeat;
    boolean accepted;

    public Request(Location requested, boolean accepted) {
        this.requestedSeat = requested;
        this.accepted = accepted;
    }

    public String showRequest(){
        return "Requested seat at "+ requestedSeat.getColumn()+" : "+ requestedSeat.getRow()+", accepted? "+accepted;
    }

    public Location getRequestedSeat() {
        return requestedSeat;
    }

    public boolean isAccepted() {
        return accepted;
    }

}
