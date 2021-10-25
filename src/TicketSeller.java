import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class TicketSeller {
    Pit pit;
    ArrayList<User> clients;
    public TicketSeller(Pit pit) {
        this.pit = pit;
        clients = new ArrayList<User>();
    }

    public void startSelling(){
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            User u = new User(this.pit);
            clients.add(u);
            ejecutor.execute(u);
        }
        ejecutor.shutdown();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
    }

    public Pit getPit() {
        return pit;
    }

    public ArrayList<User> getClients(){
        return clients;
    }

}
