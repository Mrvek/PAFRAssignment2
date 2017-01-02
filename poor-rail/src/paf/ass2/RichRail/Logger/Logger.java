package paf.ass2.RichRail.Logger;

/**
 * Instead of system.out.println(String s) call Logger.print(String s).
 * this will give a systemoutput AND an logoutput for the enabled loggers.
 */
public class Logger {

    public static void log(String s) {
        System.out.println("SYSTEM:\t" + s);
    }

}
