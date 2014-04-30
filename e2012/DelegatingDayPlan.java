package e2012;

public class DelegatingDayPlan extends DayPlan {
    
    public DelegatingDayPlan(DayPlan repeatingTuesday) {
        dayplan = repeatingTuesday.dayplan;
    }
}
