package paf.ass2.RichRail.Controller;

import paf.ass2.RichRail.Domain.Train;
import paf.ass2.RichRail.Domain.TrainManager;
import paf.ass2.RichRail.Domain.Wagon;
import paf.ass2.RichRail.Domain.WagonManager;
import paf.ass2.RichRail.Logger.Logger;

/**
 * Created by Mitchell on 02/01/2017.
 */
public class Receiver {
    public boolean executeCommand(String command) {
        String[] splitted = command.split(" ");
        switch (splitted[0].toLowerCase()) {
            case "new":
                return newObject(splitted);

            case "add":
                if (splitted.length == 4) {
                    return addWagonToTrain(splitted[1], splitted[3]);
                }
                return false;

            case "getnumseats":
                if (splitted.length == 3) {
                    return getSeats(splitted[1], splitted[2]);
                }
                return false;

            case "delete":
                if (splitted.length == 3) {
                    return delete(splitted[1], splitted[2]);
                }
                return false;

            case "remove":
                if (splitted.length == 4) {
                    return remove(splitted[3], splitted[1]);
                }
                return false;
            default:
                return false;
        }
    }


    private boolean remove(String train, String wagon) {
        TrainManager.remove(train, wagon);
        TrainManager.exportTrains();
        return true;
    }

    private boolean delete(String type, String name) {
        if (type.toLowerCase().equals("train")) {
            TrainManager.deleteTrain(name);
            TrainManager.exportTrains();
            return true;
        } else if (type.toLowerCase().equals("wagon")) {
            WagonManager.deleteWagon(name);
            TrainManager.exportTrains();
            return true;
        }
        return false;
    }

    private boolean getSeats(String type, String name) {
        if (type.toLowerCase().equals("train")) {
            TrainManager.getSeats(name);
            return true;
        } else if (type.toLowerCase().equals("wagon")) {
            WagonManager.getSeats(name);
            return true;
        }
        return false;
    }

    private boolean addWagonToTrain(String wagonname, String trainname) {
        try {
            Wagon wagon = WagonManager.getWagon(wagonname);
            Train train = TrainManager.getTrain(trainname);
            train.addWagon(wagon);
            TrainManager.exportTrains();
            return true;
        } catch (NullPointerException e) {
            Logger.logWarning(e);
        }
        return false;
    }

    private Boolean newObject(String[] splitted) {
        if (splitted[1].toLowerCase().equals("train") && splitted.length == 3) {
            return createTrain(splitted[2]);

        } else if (splitted[1].toLowerCase().equals("wagon") && splitted.length >= 3) {
            String name = splitted[2];
            if (splitted.length == 5 && splitted[3].toLowerCase().equals("numseats")) {
                return createWagon(splitted[4], name);

            } else {
                WagonManager.createWagon(name);
                TrainManager.exportTrains();
                return true;
            }
        }
        return false;
    }

    private boolean createTrain(String name) {
        TrainManager.createTrain(name);
        TrainManager.exportTrains();
        return true;
    }

    private boolean createWagon(String seats, String name) {
        int numseats = Integer.parseInt(seats);
        WagonManager.createWagon(name, numseats);
        TrainManager.exportTrains();
        return true;
    }


    public static void main(String args[]) {
        /**test for usage of the controller, remove after construction of GUI*/
        Receiver r = new Receiver();
        r.executeCommand("new train flip");
        r.executeCommand("new wagon flap");
        r.executeCommand("add flap to flip");
        r.executeCommand("new wagon flip numseats 18");
        r.executeCommand("add flip to flip");
        r.executeCommand("getnumseats train flip");
        r.executeCommand("remove flip from flip");
    }
}
