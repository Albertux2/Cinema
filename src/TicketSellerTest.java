import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TicketSellerTest {
    @Test
    void test(){
            TicketSeller ti = new TicketSeller(new Pit());
            ti.startSelling();
            ArrayList<Seat> takedSeats = new ArrayList<>();
            ti.getClients().stream().forEach((e) -> {
                if (e.getOccupiedSeat() != null)
                   takedSeats.add(e.getOccupiedSeat());
            });
            ArrayList<Seat> distinctSeats = (ArrayList) takedSeats.stream().distinct().collect(Collectors.toList());
            assertTrue(takedSeats.equals(distinctSeats));
    }
}