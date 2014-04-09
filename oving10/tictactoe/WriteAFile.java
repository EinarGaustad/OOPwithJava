package oving10.tictactoe;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteAFile {
    
    private char[][] tabel;
    private int      M;
    private int      NxN;
    private int      sumere;
    private String   filnavn;
    
    public void settInn(char[][] tabel, int M, int NxN, int sumere,
            String filnavn) {
        this.tabel = tabel;
        this.M = M;
        this.NxN = NxN;
        this.sumere = sumere;
        this.filnavn = filnavn;
    }
    
    public void run() {
        try {
            String fil = "/Users/junjun/Dropbox/ntnu2014/"
                    + "objectOrientedProgramming/oving/"
                    + "TDT4100/src/oving10/tictactoe/" + filnavn + ".txt";
            PrintWriter outFil = new PrintWriter(fil);
            outFil.println(M);
            outFil.println(NxN);
            outFil.println(sumere);
            for (int i = 0; i < tabel.length; i++) {
                String linje = "";
                for (char c : tabel[i]) {
                    linje += c;
                }
                outFil.println(linje);
            }
            outFil.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: kan ikke skrive inn!");
            System.exit(1);
        }
    }
}
