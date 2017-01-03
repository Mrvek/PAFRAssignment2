package paf.ass2.RichRail.Logger;

import paf.ass2.RichRail.GUI.Application;
import paf.ass2.RichRail.Logger.ObjectLogs.*;
import paf.ass2.RichRail.Logger.ObjectLogs.External.TXTO;
import paf.ass2.RichRail.Logger.ObjectLogs.GUI.DSL;
import paf.ass2.RichRail.Logger.ObjectLogs.GUI.GUIObject;
import paf.ass2.RichRail.Logger.TextLogs.*;
import paf.ass2.RichRail.Logger.TextLogs.External.TXTT;
import paf.ass2.RichRail.Logger.TextLogs.GUI.GUIText;

import java.io.File;
import java.util.*;

/**
 * This Class has knowledge of all logs and send the incoming messages to the enabled logs.
 * The constructor is used as a config for logs to add/remove or enable/disable them.
 * Knowledge of external and GUI logs are together here because the logger would else become a chaos of classconnections
 * and this way they are still separate of each other.
 */
public class LogsHolder {
    private HashMap<ITextLog, Boolean> textlogs = new HashMap<>();
    private HashMap<IObjectLog, Boolean> objectlogs = new HashMap<>();

    private Map<String, GUIObject> GUIObjects = new HashMap<>();
    private Map<String, GUIText> GUITexts = new HashMap<>();

    private List<Application> GUIs = new ArrayList<>();

    public LogsHolder() {
//        GUI logs, always enabled
        GUIObjects.put("DSL", new DSL());
        GUITexts.put("DSL", new paf.ass2.RichRail.Logger.TextLogs.GUI.DSL());


//        External logs
        textlogs.put(new TXTT("logs" + File.separator + "textlog.txt"), true);
        objectlogs.put(new TXTO("logs" + File.separator + "objectlog.txt"), true);
    }

    public String getGUIObject(String GUI) {
        System.out.print(GUIObjects);
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

        Set<String> GUIs = GUITexts.keySet();
        for (String GUIname : GUIs) {
            ITextLog GUI = GUITexts.get(GUIname);
            GUI.log(s);

        }
        updateGUIs();
    }

    void logWarning(Exception e) {
        Set<ITextLog> logs = textlogs.keySet();
        for (ITextLog L : logs) {
            Boolean enabler = textlogs.get(L);
            if(enabler) {
                L.logWarning(e);
            }
        }

        Set<String> GUIs = GUITexts.keySet();
        for (String GUIname : GUIs) {
            ITextLog GUI = GUITexts.get(GUIname);
            GUI.logWarning(e);
        }
        updateGUIs();
    }

    void logError(Exception e) {
        Set<ITextLog> logs = textlogs.keySet();
        for (ITextLog L : logs) {
            Boolean enabler = textlogs.get(L);
            if(enabler) {
                L.logError(e);
            }
        }

        Set<String> GUIs = GUITexts.keySet();
        for (String GUIname : GUIs) {
            ITextLog GUI = GUITexts.get(GUIname);
            GUI.logError(e);
        }
        updateGUIs();
    }

    void LogObject(Map<String, Number> wagonlist, Map<String, LinkedList<String>> trainlist) {
        Set<IObjectLog> logs = objectlogs.keySet();
        for (IObjectLog L : logs) {
            Boolean enabler = objectlogs.get(L);
            if (enabler) {
                L.export(trainlist, wagonlist);
            }
        }

        Set<String> GUIs = GUIObjects.keySet();
        for (String GUIname : GUIs) {
            IObjectLog GUI = GUIObjects.get(GUIname);
            GUI.export(trainlist, wagonlist);
        }
        updateGUIs();
    }

    public void addGUI(Application application) {
        GUIs.add(application);
    }

    private void updateGUIs() {
        for (Application a : GUIs) {
            a.updateWindows(getGUIObject(a.name), getGUIText(a.name));
        }
    }
}
