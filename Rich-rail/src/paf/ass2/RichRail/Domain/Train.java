package paf.ass2.RichRail.Domain;

import paf.ass2.RichRail.Logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 02/01/2017.
 */
public class Train {
    private String name;
    private List<Wagon> Wagonlist = new ArrayList<>();


    public Train(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public List<Wagon> getWagonlist() {
        return Wagonlist;
    }

    public void addWagon(Wagon wagon) {
        Wagonlist.add(wagon);
    }

    public Wagon getWagon(String name) throws NullPointerException {
            Wagon Result = null;
            for (Wagon i : Wagonlist) {
                if (i.getName().equals(name)) {
                    Result = i;
                }
            }

            if (Result == null) {
                throw new NullPointerException("Wagon " + name + " not found in train " + this.name);
            }
            return Result;
    }

    public int getSeats() {
        int seats = 0;
        for (Wagon w : Wagonlist) {
            seats += w.getSeats();
        }
        return seats;
    }

    public void remove(String wagon) {
        try {
            Wagon target = getWagon(wagon);
            Wagonlist.remove(target);
        } catch (NullPointerException e) {
            Logger.logWarning(e);
        }
    }

        public String toString() {
            String result = "(" + name + ")";
            for (Wagon w : Wagonlist) {
                result += "-(" + w.getName() + ")";
            }
            return result;
    }
}
