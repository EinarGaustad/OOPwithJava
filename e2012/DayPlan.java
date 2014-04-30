package e2012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DayPlan {
    
    protected List<TimeSlot> dayplan;
    
    public DayPlan() {
        dayplan = new ArrayList<TimeSlot>();
    }
    
    public void addTimeSlot(TimeSlot ts) {
        dayplan.add(ts);
    }
    public void addTimeSlot(TimeSlot ts1, TimeSlot ts2) {
        dayplan.add(ts1);
        dayplan.add(ts2);
    }
    
    public void removeTimeSlot(TimeSlot ts) {
        if (dayplan.contains(ts)) {
            dayplan.remove(ts);
        }
    }
    
    public void removeTimeSlot(TimeSlot ts1, TimeSlot ts2) {
        if (dayplan.contains(ts1)) {
            dayplan.remove(ts1);
        }
        if (dayplan.contains(ts2)) {
            dayplan.remove(ts2);
        }
    }
    
    /**
     * 
     * @param hours
     * @param minutes
     * @return earliest time in TimeSlot, else return null
     */
    public TimeSlot getTimeSlotAt(int hours, int minutes) {
        ArrayList<TimeSlot> ts = new ArrayList<TimeSlot>();

        for (TimeSlot timeSlot : dayplan) {
            if (timeSlot.contains(hours, minutes)) {
                ts.add(timeSlot);
            }
        }
        if (ts.size() == 0) {
            return null;
        }
        TimeSlot earlyPlan = ts.get(0);
        for (TimeSlot timeSlot : ts) {
            earlyPlan = timeSlot.sorting(timeSlot, earlyPlan);
        }
        return earlyPlan;
    }
    
    /**
     * 
     * @return true if there exist overlaps, false otherwise
     */
    public boolean containsOverlapping() {
        for (int i = 0; i < dayplan.size() - 1; i++) {
            for (int j = i + 1; j < dayplan.size(); j++) {
                if (dayplan.get(i).overlaps(dayplan.get(i), dayplan.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @return free time
     * 
     *         assume a day is 24 hours from 0:0 -- 23:59
     */
    public Collection<TimeSlot> getFreeTime() {
        ArrayList<TimeSlot> occupiedTime = occupiedTime();
        ArrayList<TimeSlot> freetime = new ArrayList<TimeSlot>();
        int i = 0;
        if (occupiedTime.get(0).getHours() != 0
                && occupiedTime.get(0).getMinutes() != 0) {
            i++;
            freetime.add(new TimeSlot("free time section" + i, 0, 0,
                    occupiedTime.get(0).getHours() * 60
                            + occupiedTime.get(0).getMinutes()));
        }
        while (i < occupiedTime().size()) {
            i++;
            freetime.add(new TimeSlot("free time section" + i, occupiedTime
                    .get(i - 1).getEndTime().hours, occupiedTime.get(i - 1)
                    .getEndTime().minutes,
                    (occupiedTime.get(i).getHours() * 60 + occupiedTime.get(i)
                            .getMinutes())
                            - (occupiedTime.get(i - 1).getEndTime().hours)
                            * 60
                            + occupiedTime.get(i - 1).getMinutes()));
        }
        return freetime;
    }
    
    public ArrayList<TimeSlot> occupiedTime() {
        ArrayList<TimeSlot> occupied = new ArrayList<TimeSlot>();
        ArrayList<TimeSlot> sortedDayplan = sortDayplan();
        TimeSlot start = sortedDayplan.get(0);
        for (int i = 1; i < sortedDayplan.size(); i++) {
            if (!sortedDayplan.get(i).overlaps(start, sortedDayplan.get(i))) {
                occupied.add(new TimeSlot("section." + i, start.getHours(),
                        start.getMinutes(), start.getDuration()
                                + sortedDayplan.get(i - 1).getDuration()));
                start = sortedDayplan.get(i);
            }
        }
        return occupied;
    }
    
    public ArrayList<TimeSlot> sortDayplan() {
        ArrayList<TimeSlot> sort = new ArrayList<TimeSlot>();
        for (TimeSlot ts : dayplan) {
            sort.add(ts);
        }
        TimeSlot earliest = sort.get(0);
        for (int i = 0; i < sort.size() - 1; i++) {
            for (int j = i + 1; j < sort.size(); j++) {
                earliest = sort.get(i).sorting(earliest, sort.get(j));
            }
            sort.remove(earliest);
            sort.add(i, earliest);
        }
        return sort;
    }

}
