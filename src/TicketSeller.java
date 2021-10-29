import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class TicketSeller implements Runnable{
    Pit pit;
    ArrayList<UserResponse> clients;
    ArrayDeque<Future<UserResponse>> futures = new ArrayDeque<>();


    public TicketSeller(Pit pit) {
        this.pit = pit;
        clients = new ArrayList<UserResponse>();
    }

    public void startSelling() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            User u = new User(this.pit);
            Future<UserResponse> futResponse = executor.submit(u);
            futures.add(futResponse);
        }
        executor.execute(this);
        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    @Override
    public void run() {
        do {
            Future<UserResponse> current = futures.pop();
            try {
                clients.add(current.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Returned new response from future, remaining: "+futures.size());
        }while(!futures.isEmpty());
    }

    public Pit getPit() {
        return pit;
    }

    public ArrayList<UserResponse> getClients() {
        return clients;
    }
}
