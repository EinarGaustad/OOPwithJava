package oving7.tictactoe;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadAFile {
	private char[][]	tabel;
	private int			sumere;
	private int			NxN;
	private int			M;

	public void run(String navn) {
		Scanner in;
		in = new Scanner(System.in);
        // System.out.println("skrive fil navn:");

		String filnavn = "/Users/junjun/Dropbox/ntnu2014/"
                + "objectOrientedProgramming/oving/DTD4100/"
				+ "src/oving7/tictactoe/" + navn + ".txt";

		try {
			in = new Scanner(new FileReader(filnavn));
			String line = in.nextLine();
			M = Integer.parseInt(line);
			line = in.nextLine();
			NxN = Integer.parseInt(line);
			line = in.nextLine();
			sumere = Integer.parseInt(line);
			int i = 0;
			tabel = new char [NxN][NxN];
			while (in.hasNextLine()) {
				line = in.nextLine();
				for (int j = 0; j < line.length(); j++) {
					tabel[i][j] = line.charAt(j);
				}
				i++;
			}

			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + filnavn + " not found!");
			System.exit(1);
		}
	}

	public char[][] getTabel() {
		return tabel;
	}

	public int getSumere() {
		return sumere;
	}

	public int getM() {
		return M;
	}

	public int getNxN() {
		return NxN;
	}
}
