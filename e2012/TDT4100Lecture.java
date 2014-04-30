package e2012;


public class TDT4100Lecture extends TimeSlot {
    
    public TDT4100Lecture(String description, int hours, int minutes,
            int duration) {
        super(description, hours, minutes, duration);
    }
    
    public TDT4100Lecture() {
        super("TDT4100 Lecture", 10, 15, 105);
    }
}
