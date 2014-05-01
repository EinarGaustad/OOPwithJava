package e2012;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile extends ReadWrite {
    
    private List<TimeSlot> dayplan;

    public ReadFile(String filename) {
        super();
        path += filename + ".txt";
        this.dayplan = new ArrayList<TimeSlot>();
        run();
    }
    
    public void run() {
        try {
            Scanner sc = new Scanner(new FileReader(path));
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                String description = "";
                for (int i = 0; i < line.length - 3; i++) {
                    description += line[i] + " ";
                }
                dayplan.add(new TimeSlot(description, Integer
                        .parseInt(line[line.length - 3]), Integer
                        .parseInt(line[line.length - 2]), Integer
                        .parseInt(line[line.length - 1])));
            }
            sc.close();
            resultMessage = "Done! File has been read, use getDayplan for it";
        } catch (FileNotFoundException e) {
            resultMessage = "File not found" + e;
        }
    }
    
    /**
     * 
     * @return dayplan arraylist<timeSlot> from file
     */
    public List<TimeSlot> getDayplan() {
        return dayplan;
    }
}
