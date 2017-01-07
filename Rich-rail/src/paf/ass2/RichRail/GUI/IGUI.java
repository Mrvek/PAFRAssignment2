package paf.ass2.RichRail.GUI;

import paf.ass2.RichRail.Controller.Receiver;

/**
 * Created by Mitchell on 07/01/2017.
 */
public interface IGUI {
    Receiver rec = new Receiver();
    void updateText(String text);
    void updateObject(String object);
}
