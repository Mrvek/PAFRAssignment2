package paf.ass2.RichRail.Domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 02/01/2017.
 */
public class WagonManager {
    private static List<Wagon> wagonList = new ArrayList<>();

    public static void createWagon(String name) {
        Wagon newwagon = new Wagon(name, 20);
        wagonList.add(newwagon);
    }

    public static void createWagon(String name, int seats) {
        Wagon newwagon = new Wagon(name, seats);
        wagonList.add(newwagon);
    }

    public static Wagon getWagon(String name) throws NullPointerException {
        Wagon Result = null;
        for (Wagon i : wagonList) {
            if (i.getName().equals(name)) {
                Result = i;
            }
        }

        if (Result == null) {
            throw new NullPointerException("Wagon " + name + " not found in the wagonList");
        }
        return Result;
    }

    public static int getSeats(String name) {
        Wagon wagon = getWagon(name);
        return wagon.getSeats();
    }

    public static void deleteWagon(String name) {
        Wagon wagon = getWagon(name);
        wagonList.remove(wagon);
    }
}
