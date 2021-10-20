import java.util.ArrayList;

public class Client {
    Chair occupiedChair;
    ArrayList<Request> requests;


    public Client(Chair occupiedChair) {
        this.occupiedChair = occupiedChair;
        this.requests = new ArrayList<Request>();
    }
}
