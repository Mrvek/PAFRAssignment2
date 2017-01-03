package paf.ass2.RichRail.Logger.ObjectLogs.GUI;

import paf.ass2.RichRail.Logger.ObjectLogs.IObjectLog;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Log with output to the GUI
 */
public class DSL extends GUIObject {
    private String objectLog = "";

    @Override
    public void export(Map<String, LinkedList<String>> trainList, Map<String, Number> wagonList) {
        objectLog = "wagons\n";
        Set<String> wagonnames = wagonList.keySet();
        for (String name : wagonnames) {
            objectLog += "(" + name + ":" + wagonList.get(name) + ") ";
        }

        objectLog += "\ntrains";
        Set<String> trainnames = trainList.keySet();
        for (String name : trainnames) {
            objectLog += "\n(" + name + ")";
            for (String wagonname : trainList.get(name)) {
                objectLog += "-(" + wagonname + ")";
            }
        }
    }
    @Override
    public String toString() {
        return objectLog;
    }
}
