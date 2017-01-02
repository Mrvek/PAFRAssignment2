package paf.ass2.RichRail.Domain;

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

    public Wagon getWagon(String name) throws Exception {
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
}
