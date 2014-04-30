package e2012;

import java.util.ArrayList;



public class TDT4100DayPlan extends DayPlan {
    
    protected final TDT4100Lecture TDT;
    
    public TDT4100DayPlan() {
        TDT = new TDT4100Lecture();
        dayplan = new ArrayList<TimeSlot>();
        dayplan.add(TDT);
    }
    
    @Override
    public void addTimeSlot(TimeSlot ts) {
        if (TDT.overlaps(TDT, ts)) {
            throw new IllegalArgumentException(
                    "can not be created, overlaps with TDT4100 Lecture");
        }
        dayplan.add(ts);
    }

    @Override
    public void removeTimeSlot(TimeSlot ts) {
        if (dayplan.contains(ts) && ts != TDT) {
            dayplan.remove(ts);
        }
    }
}
