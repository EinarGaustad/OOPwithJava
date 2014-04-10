package oving10.sokoban;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadAFile {
    
    private char[][] grid;
    private int      gridHeight;
    private int      gridWidth;
    private String   errMessage;
    
    public ReadAFile() {
        errMessage = "";
    }

    public void run(String navn) {
        Scanner in;
        in = new Scanner(System.in);
        String filnavn;
        if (navn.contains("/")) {
            filnavn = navn;
        } else {
            filnavn = "/Users/junjun/Dropbox/ntnu2014/"
                    + "objectOrientedProgramming/oving/TDT4100/"
                    + "src/oving10/sokoban/" + navn + ".txt";
        }
        
        try {
            in = new Scanner(new FileReader(filnavn));
            String line = in.nextLine();
            gridHeight = Integer.parseInt(line);
            line = in.nextLine();
            gridWidth = Integer.parseInt(line);
            grid = new char[gridHeight][gridWidth];
            String gridContent = in.nextLine();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = gridContent.charAt(j + gridWidth * i);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            errMessage = "Error: " + filnavn + " not found!";
        }
    }
    
    public String getMessage() {
        return errMessage;
    }

    public char[][] getGrid() {
        return this.grid;
    }
    
    public String toString() {
        String s="";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                s+=grid[i][j];
            }
            s+="\n";
        }
        return s;
    }
}
