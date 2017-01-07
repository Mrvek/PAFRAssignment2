package paf.ass2.RichRail.Logger;

import paf.ass2.RichRail.GUI.Application;
import paf.ass2.RichRail.Logger.TextLogs.External.TXTT;
import paf.ass2.RichRail.Logger.TextLogs.GUI.DSL;
import paf.ass2.RichRail.Logger.TextLogs.GUI.GUIText;
import paf.ass2.RichRail.Logger.TextLogs.ITextLog;

import java.io.File;
import java.util.*;

/**
 * Created by Mitchell on 07/01/2017.
 */
public class TextManager {
    private HashMap<ITextLog, Boolean> textlogs = new HashMap<>();
    private Map<String, GUIText> GUITexts = new HashMap<>();
    private List<Application> GUIs = new ArrayList<>();

    public TextManager() {
//        GUI Logs, always enabled
        GUITexts.put("DSL", new DSL());

//        External Files
        textlogs.put(new TXTT("logs" + File.separator + "Text" + File.separator + "textlog.txt"), true);
    }


    void logText(String s) {
        Set<ITextLog> logs = textlogs.keySet();
        for (ITextLog L : logs) {
            Boolean enabler = textlogs.get(L);
            if (enabler) {
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
            if (enabler) {
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
            if (enabler) {
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

    private void updateGUIs() {
        for (Application a : GUIs) {
            a.updateText(getGUIText(a.name));
        }
    }

    public void addGUI(Application application) {
        GUIs.add(application);
    }

    private String getGUIText(String GUI) {
        ITextLog get = GUITexts.get(GUI);
        return get.toString();
    }
}
