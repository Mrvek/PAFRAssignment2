package paf.ass2.RichRail.Logger;

import paf.ass2.RichRail.Domain.Train;
import paf.ass2.RichRail.Domain.Wagon;

import java.util.List;

/**
 * Created by Mitchell on 03/01/2017.
 */
public interface IObjectLog {
    void export(List<Train> trainList, List<Wagon> wagonList);
}
