package paf.ass2.RichRail.Logger;

import java.util.HashMap;

/**
 * Created by Mitchell on 03/01/2017.
 */
public class LogConfig {
    private HashMap<ITextLog, Boolean> textlogs = new HashMap<>();
    private HashMap<IObjectLog, Boolean> objectlogs = new HashMap<>();

    public LogConfig() {

    }
}
