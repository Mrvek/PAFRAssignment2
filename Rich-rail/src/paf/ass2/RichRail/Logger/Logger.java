package paf.ass2.RichRail.Logger;

import paf.ass2.RichRail.Domain.Train;
import paf.ass2.RichRail.Domain.Wagon;
import paf.ass2.RichRail.GUI.Application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Instead of system.out.println(String s) call Logger.print(String s).
 * this will give a systemoutput AND an logoutput for the enabled loggers.
 * Warnings and Errors have their own methods.
 * This class converts the input to the requested output for the interfaces and gives this output to the Logconfig.
 */
public class Logger {
    private static ObjectManager objectmaker = new ObjectManager();
    private static TextManager textmaker = new TextManager();

    public static void log(String s) {
        System.out.println("SYSTEM:\t" + s);
        textmaker.logText(s);
    }

    public static void logError(Exception e) {
        System.out.println("ERROR!:\t" + e.getMessage() + "\n\tSee for more information in the logs.");
        textmaker.logError(e);
    }

    public static void logWarning(Exception e) {
        System.out.println("WARNING!:\t" + e.getMessage() + "\n\tSee for more information in the logs.");
        textmaker.logWarning(e);
    }


    public static void export(List<Train> trainList, List<Wagon> wagonList) {
        HashMap<String, Number> wagons = new HashMap<>();
        for (Wagon w : wagonList) {
            wagons.put(w.getName(), w.getSeats());
        }

        HashMap<String, LinkedList<String>> trains = new HashMap<>();
        for (Train t : trainList) {
            LinkedList<String> attachedwagons = new LinkedList<>();
            for (Wagon w : t.getWagonlist()) {
                attachedwagons.add(w.getName());
            }
            trains.put(t.getName(), attachedwagons);
        }

        objectmaker.LogObject(wagons, trains);
    }

    public static void registerGUI(Application application) {
        objectmaker.addGUI(application);
        textmaker.addGUI(application);
    }
}
