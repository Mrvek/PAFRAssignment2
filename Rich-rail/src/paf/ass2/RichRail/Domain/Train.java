package paf.ass2.RichRail.Domain;

import paf.ass2.RichRail.Logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 02/01/2017.
 */
public class Train {
    private String name;
    private List<Wagon> wagonlist = new ArrayList<>();


    public Train(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public List<Wagon> getWagonlist() {
        return wagonlist;
    }

    public void addWagon(Wagon wagon) {
        wagonlist.add(wagon);
        Logger.log("Added wagon " + wagon.getName() + " to train " + name);
    }

    private Wagon getWagon(String name) throws NullPointerException {
            Wagon Result = null;
            for (Wagon i : wagonlist) {
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
        for (Wagon w : wagonlist) {
            seats += w.getSeats();
        }
        return seats;
    }

    public void remove(String wagon) {
        try {
            Wagon target = getWagon(wagon);
            wagonlist.remove(target);
        } catch (NullPointerException e) {
            Logger.logWarning(e);
        }
    }

        public String toString() {
            String result = "(" + name + ")";
            for (Wagon w : wagonlist) {
                result += "-(" + w.getName() + ")";
            }
            return result;
    }
}
