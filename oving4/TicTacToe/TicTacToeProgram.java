package oving4.TicTacToe;

import java.util.Scanner;

/*
 Trinn 2 - spillerne kan legge brikker. 
 I dette trinnet lages en enkel versjon av TicTacToeProgram-klassen, 
 slik at spillerne etter tur kan legge brikker ved å angi x,y-posisjonen til ruta 
 som brikken skal legges i. TicTacToeProgram-klassen skal ta seg av all input og 
 utskrift. For interaksjon med brukeren kan det være lurt å bruker Scanner-klassen.
 */
public class TicTacToeProgram {
	
	public static void main(String[] args) {
		TicTacToe tictactoe = new TicTacToe();
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(tictactoe.toString());
			if (tictactoe.vinne() == ' ') {
				// boolean nyVerdi = false;
				int x = 0;
				int y = 0;
				String flytte;
				while (true) {
					flytte = in.next();
					if (tictactoe.isValid(flytte))
						break;
					else
						System.out
								.println("feil inndato, kjekk skrive inn igjen!");
				}
				x = Integer.parseInt("" + flytte.charAt(0));
				y = Integer.parseInt("" + flytte.charAt(1));
				tictactoe.setInn(x, y);
				
			} else
				break;
			
			if (tictactoe.getSumere() == 9) {
				System.out.println(tictactoe.toString());
				break;
			}
		}
		in.close();
		// System.out.println(tictactoe.toString());
		
	}
}
