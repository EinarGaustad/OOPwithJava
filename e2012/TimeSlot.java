package e2012;

public class TimeSlot {
    
    private String description;
    private int    hours, minutes, duration, endHours, endMinutes;
    
    public TimeSlot(String description, int hours, int minutes, int duration) {
        this.description = description;
        this.hours = hours;
        this.minutes = minutes;
        this.duration = duration;
        this.endHours = hours + (minutes + duration) / 60;
        this.endMinutes = (minutes + duration) % 60;
    }
    
    public String timeFormat() {
        return (hours < 10 ? ("0" + hours) : hours) + ":"
                + (minutes < 10 ? ("0" + minutes) : minutes) + "-"
                + (endHours < 10 ? ("0" + endHours) : endHours) + ":"
                + (endMinutes < 10 ? ("0" + endMinutes) : endMinutes);
    }
    
    public String toString() {
        return description + "@" + timeFormat();
    }
    
    public DayTime getStartTime() {
        return new DayTime(hours, minutes);
    }
    
    public DayTime getEndTime() {
        return new DayTime(endHours, endMinutes);
    }
    
    public int getDuration() {
        return duration;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getMinutes() {
        return minutes;
    }
    
    /**
     * 
     * @param hours
     * @param minutes
     * @return True if TimeSlot contains time point; false otherwise
     */
    public boolean contains(int hours, int minutes) {
        return (hours * 60 + minutes < this.hours * 60 + this.minutes
                + duration)
                && (hours * 60 + minutes >= this.hours * 60 + this.minutes);
    }
    
    /**
     * 
     * @param ts1
     * @param ts2
     * @return True if overlaps, false otherwise
     */
    public boolean overlaps(TimeSlot ts1, TimeSlot ts2) {
        return ((ts1.getHours() * 60 + ts1.getMinutes() >= ts2.getHours() * 60
                + ts1.getMinutes()) && (ts1.getHours() * 60 + ts1.getMinutes() < ts2
                .getHours() * 60 + ts1.getMinutes() + ts2.getDuration()))
                || ((ts1.getHours() * 60 + ts1.getMinutes() + ts1.getDuration() >= ts2
                        .getHours() * 60 + ts1.getMinutes()) & (ts1.getHours()
                        * 60 + ts1.getMinutes() + ts1.getDuration() < ts2
                        .getHours() * 60 + ts1.getMinutes() + ts2.getDuration()));
    }
    
    public TimeSlot sorting(TimeSlot ts1, TimeSlot ts2) {
        if (ts1.getHours() == ts2.getHours()) {
            return ts1.getMinutes() > ts2.getMinutes() ? ts1 : ts2;
        }
        return ts1.getHours() > ts2.getHours() ? ts1 : ts2;
    }

    //    Differences in boolean operators: & vs && and | vs ||
    //    Those are the bitwise AND and bitwise OR operators.
    //
    //    int a = 6; // 110
    //    int b = 4; // 100
    //
    //    // Bitwise AND    
    //
    //    int c = a & b;
    //    //   110
    //    // & 100
    //    // -----
    //    //   100
    //
    //    // Bitwise OR
    //
    //    int d = a | b;
    //    //   110
    //    // | 100
    //    // -----
    //    //   110
    //
    //    System.out.println(c); // 4
    //    System.out.println(d); // 6
    //    EDIT
    //
    //    regarding the different behaviors of the operator based on its inputs.
    //
    //    Indeed when both inputs are boolean, the operators are considered the
    //      Boolean Logical Operators and behave similar to the Conditional-And
    //      (&&) and Conditional-Or (||) operators except for the fact that they
    //      don't short-circuit so while the following is safe:
    //
    //    if((a != null) && (a.something == 3)){//is safe
    //    }
    //
    //    This is not:
    //
    //    if((a != null) & (a.something == 3)){
    //    }
}
