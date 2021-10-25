public class Request {
    Location requestedLocation;
    boolean accepted;

    public Request(Location requested, boolean accepted) {
        this.requestedLocation = requested;
        this.accepted = accepted;
    }

    public String showRequest(){
        return " Requested seat at "+ requestedLocation.getColumn()+" : "+ requestedLocation.getRow()+", accepted? "+accepted;
    }

    public Location getRequestedLocation() {
        return requestedLocation;
    }

    public boolean isAccepted() {
        return accepted;
    }

}
