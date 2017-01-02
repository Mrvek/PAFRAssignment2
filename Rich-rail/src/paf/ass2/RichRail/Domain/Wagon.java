package paf.ass2.RichRail.Domain;

/**
 * Created by Mitchell on 02/01/2017.
 */
public class Wagon {
    private String Name;
    private int seats;

    public Wagon(String name, int seats) {
        Name = name;
        this.seats = seats;
    }

    public String getName() {
        return Name;
    }

    public int getSeats() {
        return seats;
    }
}
