package paf.ass2.RichRail.Logger.TextLogs.External;

import paf.ass2.RichRail.Logger.TextLogs.ITextLog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mitchell on 03/01/2017.
 */
public class TXTT implements ITextLog{
    private String filepath;

    public TXTT(String filepath) {
        this.filepath = filepath;
    }

    private void write(String loginfo) {
        try {
            File file = new File(filepath);
            FileWriter fw = null;
            fw = new FileWriter(file,true);
            fw.write("\n" + loginfo);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String s) {
        write(s);
    }

    @Override
    public void logError(Exception e) {
        write(e.getMessage());
    }

    @Override
    public void logWarning(Exception e) {
        write(e.getMessage());
    }
}
