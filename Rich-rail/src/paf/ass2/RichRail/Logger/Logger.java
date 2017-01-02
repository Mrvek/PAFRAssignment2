package paf.ass2.RichRail.Logger;

import paf.ass2.RichRail.DSL.Receiver;
import paf.ass2.RichRail.Domain.Train;

import java.util.List;

/**
 * Instead of system.out.println(String s) call Logger.print(String s).
 * this will give a systemoutput AND an logoutput for the enabled loggers.
 * Warnings and Errors have their own methods.
 */
public class Logger {

    public static void log(String s) {
        System.out.println("SYSTEM:\t" + s);
        /*TODO: logoutput to external files*/
    }

    public static void logError(Exception e) {
        System.out.println("ERROR!:\t" + e.getMessage() + "\n\tSee for more information in the logs.");
        /*TODO: logoutput to external files*/
    }

    public static void logWarning(Exception e) {
        System.out.println("WARNING!:\t" + e.getMessage() + "\n\tSee for more information in the logs.");
        /*TODO: logoutput to external files*/
    }

    public static void export(List<Train> trainList) {
        System.out.println("SYSTEM:\texporting trains...");
        /*TODO: export to external files*/


        System.out.println("SYSTEM:\texporting complete!");
    }

}
