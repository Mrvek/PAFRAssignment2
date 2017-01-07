package paf.ass2.RichRail.Logger.TextLogs.GUI;

import java.util.LinkedList;

/**
 * Created by Mitchell on 03/01/2017.
 */
public class DSL extends GUIText {
    private LinkedList<String> logholder = new LinkedList<>();

    @Override
    public void log(String s) {
        add(s);
    }

    @Override
    public void logError(Exception e) {
        add(e.getMessage());
    }

    @Override
    public void logWarning(Exception e) {
        add(e.getMessage());
    }

    private void add(String s) {
        int availablerows = 10;
        while (logholder.size() >= availablerows) {
            logholder.removeFirst();
        }
        logholder.add(s);
    }

    public String toString() {
        String result = "";
        for (String row : logholder) {
            if (result.isEmpty()) {
                result = row;
            } else {
                result += "\n" + row;
            }
        }
        return result;
    }
}
