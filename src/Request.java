public class Request {
    Location requested;
    boolean accepted;

    public Request(Location requested, boolean accepted) {
        this.requested = requested;
        this.accepted = accepted;
    }

    public void showRequest(){
        System.out.println("Requested chair at "+requested.getColumn()+" : "+requested.getRow()+", accepted? "+accepted);
    }

    public Location getRequested() {
        return requested;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public static void main(String[] args) {
        Request r = new Request(new Location('a',2),false);
        r.showRequest();
    }
}
