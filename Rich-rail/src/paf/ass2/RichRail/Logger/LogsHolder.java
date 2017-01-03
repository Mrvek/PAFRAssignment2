package paf.ass2.RichRail.Logger;

import paf.ass2.RichRail.Logger.ObjectLogs.*;
import paf.ass2.RichRail.Logger.ObjectLogs.GUI.DSLObject;
import paf.ass2.RichRail.Logger.TextLogs.*;
import paf.ass2.RichRail.Logger.TextLogs.GUI.DSLText;

import java.util.*;

/**
 * This Class has knowledge of all logs and send the incoming messages to the enabled logs.
 * The constructor is used as a config for logs to add/remove or enable/disable them.
 */
class LogsHolder {
    private HashMap<ITextLog, Boolean> textlogs = new HashMap<>();
    private HashMap<IObjectLog, Boolean> objectlogs = new HashMap<>();

    private Map<String, IObjectLog> GUIObjects = new HashMap<>();
    private Map<String, ITextLog> GUITexts = new HashMap<>();

    LogsHolder() {
//        GUI logs, always enabled
        GUIObjects.put("DSL", new DSLObject());
        GUITexts.put("DSL", new DSLText());


//        External logs

    }


    public String getGUIObject(String GUI) {
        IObjectLog get =  GUIObjects.get(GUI);
        return get.toString();
    }

    public String getGUIText(String GUI) {
        ITextLog get = GUITexts.get(GUI);
        return get.toString();
    }


    void logText(String s) {
        Set<ITextLog> logs = textlogs.keySet();
        for (ITextLog L : logs) {
            Boolean enabler = textlogs.get(L);
            if(enabler) {
                L.log(s);
            }
        }
    }

    void logWarning(Exception e) {
        Set<ITextLog> logs = textlogs.keySet();
        for (ITextLog L : logs) {
            Boolean enabler = textlogs.get(L);
            if(enabler) {
                L.logWarning(e);
            }
        }
    }

    void logError(Exception e) {
        Set<ITextLog> logs = textlogs.keySet();
        for (ITextLog L : logs) {
            Boolean enabler = textlogs.get(L);
            if(enabler) {
                L.logError(e);
            }
        }
    }

    void LogObject(Map<String, Number> wagonlist, Map<String, LinkedList<String>> trainlist) {
        Set<IObjectLog> logs = objectlogs.keySet();
        for (IObjectLog L : logs) {
            Boolean enabler = objectlogs.get(L);
            if (enabler) {
                L.export(trainlist, wagonlist);
            }
        }
    }
}
