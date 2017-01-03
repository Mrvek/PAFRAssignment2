package paf.ass2.RichRail.Logger.ObjectLogs;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Mitchell on 03/01/2017.
 */
public interface IObjectLog {
    void export(Map<String, LinkedList<String>> trainList, Map<String, Number> wagonList);
}
