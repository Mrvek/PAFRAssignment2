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
public class ObjectManager {
    private HashMap<IObjectLog, Boolean> objectlogs = new HashMap<>();

    private Map<String, GUIObject> GUIObjects = new HashMap<>();

    private List<Application> GUIs = new ArrayList<>();

    public ObjectManager() {
//        GUI logs, always enabled
        GUIObjects.put("DSL", new DSL());


//        External logs
        objectlogs.put(new TXTO("logs" + File.separator + "Text" + File.separator + "objectlog.txt"), true);
    }

    private String getGUIObject(String GUI) {
        IObjectLog get =  GUIObjects.get(GUI);
        return get.toString();
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
            a.updateObject(getGUIObject(a.name));
        }
    }
}
