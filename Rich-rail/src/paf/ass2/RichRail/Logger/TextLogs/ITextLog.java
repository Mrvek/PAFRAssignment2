package paf.ass2.RichRail.Logger.TextLogs;

/**
 * Created by Mitchell on 03/01/2017.
 */
public interface ITextLog {
    void log(String s);
    void logError(Exception e);
    void logWarning(Exception e);
}
