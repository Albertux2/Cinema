public class Cinema {

    private Pit pit;
    private static Cinema instance;

    private Cinema(Pit pit) {
        this.pit = pit;
    }

    public static Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema(new Pit());
        }
        return instance;
    }

    public void fillPit(int desiredRows, int desiredColumns) {
        for (int i = 0; i < desiredRows; i++) {
            char row = (char) ('a' + i);
            for (int j = 0; j < desiredColumns; j++) {
                Location actualLocation = new Location(row, j);
                Seat mySeat = new Seat(actualLocation);
                pit.addSeat(actualLocation, mySeat);
            }
        }
    }

    public Pit getPit() {
        return pit;
    }
}
