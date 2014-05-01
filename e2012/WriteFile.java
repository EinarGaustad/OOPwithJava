package e2012;

// import java.io.File;
import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteFile extends ReadWrite {
    
    public WriteFile(List<TimeSlot> dayplan, String filename) {
        super();
        path += filename + ".txt";
        run(dayplan);
    }
    
    public void run(List<TimeSlot> dayplan) {
        try {
            //File file = new File(path);
            PrintWriter pw = new PrintWriter(path);
            //FileWriter fw = new FileWriter(path);// not used her, but useful to know PrintWriter and FileWriter
            for (TimeSlot ts : dayplan) {
                pw.println(ts.getDescription() + " " + ts.getHours() + " "
                        + ts.getMinutes() + " "
                        + ts.getDuration());
                //fw.write();
            }
            pw.close();
            resultMessage = "Done ! File saved at: " + path;
            //fw.close();
        } catch (FileNotFoundException e) {
            resultMessage = "Can not write in! File not found!";
            //        } catch (IOException e) {
            //            // TODO Auto-generated catch block
            //            e.printStackTrace();
        }
    }
}
