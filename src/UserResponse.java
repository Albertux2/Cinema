import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserResponse {
    private ArrayList<Request> requests;
    private User user;
    private Seat mySeat;

    public UserResponse(ArrayList<Request> requests, User user, Seat mySeat) {
        this.requests = requests;
        this.user = user;
        this.mySeat = mySeat;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public User getUser() {
        return user;
    }

    public Seat getMySeat() {
        return mySeat;
    }
}
