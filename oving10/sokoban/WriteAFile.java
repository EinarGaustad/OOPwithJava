package oving10.sokoban;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteAFile {
    
    private char[][] grid;
    private String   filnavn;
    private String   errMessage;
    
    public WriteAFile(char[][] grid, String filnavn) {
        errMessage = "";
        this.grid = grid;
        if (filnavn.contains("/") && filnavn.contains(".txt")) {
            this.filnavn = filnavn;
        } else {
            this.filnavn = "/Users/junjun/Dropbox/ntnu2014/"
                    + "objectOrientedProgramming/oving/"
                    + "TDT4100/src/oving10/sokoban/" + filnavn + ".txt";
        }
    }
    
    public void run() {
        try {
            PrintWriter outFil = new PrintWriter(filnavn);
            outFil.println(grid.length);
            outFil.println(grid[0].length);
            String gridContent = "";
            for (int i = 0; i < grid.length; i++) {
                for (char c : grid[i]) {
                    gridContent += c;
                }
            }
            outFil.println(gridContent);
            outFil.close();
        } catch (FileNotFoundException e) {
            errMessage = "Error: can not write to this file";
        }
    }
    
    public String getMessage() {
        return errMessage;
    }
}
