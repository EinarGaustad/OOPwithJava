package e2012;


public class Test {
    
    public static void main(String[] args) {
        DayPlan tuesday = new TDT4100DayPlan();
        tuesday.addTimeSlot(new TimeSlot("test1", 8, 1, 8), new TimeSlot(
                "test2", 0, 0, 5));
        System.out.println(tuesday.getTimeSlotAt(10, 30));
        System.out.println(tuesday.getTimeSlotAt(8, 5));
        System.out.println(tuesday.getTimeSlotAt(0, 3));
        tuesday.addTimeSlot(new TimeSlot("Coffee break", 12, 30, 60));
        System.out.println("----");

        DayPlan repeatingTuesday = new TDT4100DayPlan();
        DelegatingDayPlan tuesday2 = new DelegatingDayPlan(repeatingTuesday);
        System.out.println(tuesday2.getTimeSlotAt(10, 30));
        // prints "TDT4100 lecture@10:15-12:00" since tuesday logically includes the TDT4100Lecture in repeatingTuesday
        tuesday2.addTimeSlot(new TimeSlot("Coffee break", 11, 30, 60));
        System.out.println(tuesday2.containsOverlapping());
        // prints "true" since timeSlot in tuesday overlaps with TDT4100Lecture in repeatingTuesday
    }
}
