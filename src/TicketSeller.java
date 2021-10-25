import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketSeller {
    Pit pit;

    public TicketSeller(Pit pit) {
        this.pit = pit;
    }

    public Pit getPit() {
        return pit;
    }

    public static void main(String[] args) {
        TicketSeller ti = new TicketSeller(new Pit());
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            ejecutor.execute(new User(ti.getPit()));
        }
        ejecutor.shutdown();
    }
}
