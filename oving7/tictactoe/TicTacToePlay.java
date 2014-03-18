package oving7.tictactoe;

import java.util.Scanner;

public class TicTacToePlay {
	public static void main(String[] args) {
		Ttt tictactoe = new TicTacTAngre();
		Scanner in = new Scanner(System.in);
		System.out.println("New Game" + "\n" + "Load a Game" + "\n"
				+ "skrive 'n' for New Game" + "\n"
				+ "skrive 'l' for load a game");
		String svar = in.next();
		if (svar.equalsIgnoreCase("l")) {
			ReadAFile loadgame = new ReadAFile();
			loadgame.run("filnavn");//
			if (loadgame.getM() == 3 && loadgame.getNxN()==3){
				tictactoe = new TicTacTAngre();
				tictactoe.loadgame(loadgame.getTabel(),loadgame.getM(),loadgame.getNxN(), loadgame.getSumere());
			}
			else{
				tictactoe = new TicTacTAngre(loadgame.getM(),loadgame.getNxN());
				tictactoe.loadgame(loadgame.getTabel(),loadgame.getM(),loadgame.getNxN(), loadgame.getSumere());
			}
		} else if (svar.equalsIgnoreCase("n")) {
			while (true) {
				System.out.println("skrive d for default Game" + "\n"
						+ "vil du ha egen definert Game?" + "\n"
						+ "skrive tall på rad og tall for brett,"
						+ " skille med '-' !");
				svar = in.next();
				if (svar.equalsIgnoreCase("d")) {
					tictactoe = new TicTacTAngre();
					break;
				}
				String[] tabelS = svar.split("-");
				if (tabelS.length != 2) {
					System.out.println("feil inndata, skrive igjen!");
				} else {
					try {
						int M = Integer.parseInt(tabelS[0]);
						int NxN = Integer.parseInt(tabelS[1]);
						if (NxN >= M && M > 1 && NxN < 10) {
							tictactoe = new TicTacTAngre(M, NxN);
							break;
						} else {
							System.out.println("9>=brett >= rad og rad > 1, skrive igjen");
						}
					} catch (NumberFormatException e) {
						System.out.println(e);
					}
				}

			}
			
		}
		boolean stop = false;
		while (true) {
			System.out.println(tictactoe.toString());
			if (tictactoe.vinne() == ' ') {
				// boolean nyVerdi = false;
				String flytte;
				while (true) {
					flytte = in.next();
					if (flytte.equalsIgnoreCase("a")) {
						tictactoe.undo();
						break;
					} else if (flytte.equalsIgnoreCase("r")) {
						tictactoe.redo();
						break;
					} else if (flytte.equalsIgnoreCase("s")) {
						System.out
								.println("game will be saved! skrive en navn:");
						flytte = in.next();
						WriteAFile skrivefil = new WriteAFile();
						skrivefil.settInn(tictactoe.getTabel(),tictactoe.getM(),tictactoe.getNxN(),
								tictactoe.getSumere(), flytte);
						skrivefil.run();
						System.out.println("Game Saved!");
						stop = true;
						break;
					} else if (tictactoe.isValid(flytte)) {
						tictactoe.setInn(flytte);
						break;
					} else {
						System.out
								.println("feil inndato, kjekk skrive inn igjen!");
					}
				}
			} else
				// vinnet
				break;

			if (tictactoe.getSumere() == tictactoe.getBlock()) {
				System.out.println(tictactoe.toString());
				break;
			}
			if (stop) {
				break;
			}
		}
		in.close();
	}
}
