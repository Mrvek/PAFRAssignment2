package paf.ass2.RichRail.Domain;

import java.util.ArrayList;
import java.util.List;
import paf.ass2.RichRail.Logger.Logger;

/**
 * Created by Mitchell on 02/01/2017.
 */
public class TrainManager {
    private static List<Train> trainList = new ArrayList<>();

    public static void createTrain(String name) {
        Train newtrain = new Train(name);
        trainList.add(newtrain);
    }

    public static Train getTrain(String name) throws NullPointerException {
        Train Result = null;
        for (Train i : trainList) {
            if (i.getName().equals(name)) {
                Result = i;
            }
        }

        if (Result == null) {
            throw new NullPointerException("Train " + name + " not found in the trainList");
        }
        return Result;
    }

    public static void exportTrains() {
        Logger.export(trainList);
    }

    public static int getSeats(String name) {
        Train train = getTrain(name);
        return train.getSeats();
    }

    public static void deleteTrain(String name) {
        Train train = getTrain(name);
        trainList.remove(train);
    }

    public static void remove(String train, String wagon) {
        Train target = getTrain(train);
        target.remove(wagon);
    }
}
