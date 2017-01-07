package paf.ass2.RichRail.Logger.ObjectLogs.External;

import paf.ass2.RichRail.Logger.Logger;
import paf.ass2.RichRail.Logger.ObjectLogs.IObjectLog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Mitchell on 03/01/2017.
 */
public class TXTO implements IObjectLog {
    private String filepath;

    public TXTO(String path) {
        filepath = path;
    }

    @Override
    public void export(Map<String, LinkedList<String>> trainList, Map<String, Number> wagonList) {
        String result = "wagons\n";
        for(String name : wagonList.keySet()) {
            result += "(" + name + ":" + wagonList.get(name) + ") ";
        }

        result += "\ntrains";
        for (String name : trainList.keySet()) {
            result += "\n(" + name + ")";
            for (String wagon : trainList.get(name)) {
                result += "-(" + wagon + ")";
            }
        }
        write(result);
    }

    private void write(String result) {
        File file = new File(filepath);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(result);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            Logger.logError(e);
        }
    }
}
