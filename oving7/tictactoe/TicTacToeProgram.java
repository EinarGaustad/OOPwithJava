package oving7.tictactoe;

import java.util.Scanner;

public class TicTacToeProgram implements ConsoleGame {
	private boolean	inited	= false;
	private Ttt		tictactoe;

	public void init(String level) {
		String[] tabelS = level.split("-");
		if (tabelS.length != 2) {
			System.out.println("feil inndata!");
		} else {
			try {
				int M = Integer.parseInt(tabelS[0]);
				int NxN = Integer.parseInt(tabelS[1]);
				if (NxN >= M && M > 1 && NxN < 10) {
					inited = true;
					if (M == 3 && NxN == 3) {
						tictactoe = new TicTacTAngre();
					} else {
						tictactoe = new TicTacTAngre(M, NxN);
					}
				} else {
					inited = false;
					System.out.println("9>=brett >= rad og rad > 1");
				}
			} catch (NumberFormatException e) {
				inited = false;
				System.out.println(e);
			}
		}
	}

	public void run() {
		if (!inited) {
			System.out.println("init first!!!!");
		} else {
			Scanner in = new Scanner(System.in);
			boolean stop = false;
			while (true) {
				System.out.println(tictactoe.toString());
				if (tictactoe.vinne() == ' ') {
					// boolean nyVerdi = false;
					String flytte;
					
					while (true) {
						flytte = in.next();
						System.out.println(flytte);
						if (flytte.equalsIgnoreCase("u")) {// u for undo
							tictactoe.undo();
							break;
						} else if (flytte.equalsIgnoreCase("r")) {// r for redo
							tictactoe.redo();
							break;
						} else if (flytte.charAt(0) == '>' && flytte.length()>1) {
							// >filnavn: lagrer tilstanden til spillet i filen
							// ved navn filnavn
							String filnavn = flytte.substring(1);
							System.out.println(filnavn);
							WriteAFile skrivefil = new WriteAFile();
							skrivefil.settInn(tictactoe.getTabel(),
									tictactoe.getM(), tictactoe.getNxN(),
									tictactoe.getSumere(), filnavn);
							skrivefil.run();
							System.out.println("Game Saved!");
							System.out.println("Game stopped!");
							stop = true;
							break;
						} else if (flytte.charAt(0) == '<' && flytte.length()>1) {
							// <filnavn load game
							String filnavn = flytte.substring(1);
							ReadAFile loadgame = new ReadAFile();
							loadgame.run(filnavn);
							if (loadgame.getM() == 3 && loadgame.getNxN() == 3) {
								tictactoe = new TicTacTAngre();
								tictactoe.loadgame(loadgame.getTabel(),
										loadgame.getM(), loadgame.getNxN(),
										loadgame.getSumere());
								break;
							} else {
								tictactoe = new TicTacTAngre(loadgame.getM(),
										loadgame.getNxN());
								tictactoe.loadgame(loadgame.getTabel(),
										loadgame.getM(), loadgame.getNxN(),
										loadgame.getSumere());
								break;
							}
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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("skrive d for default Game" + "\n"
					+ "vil du ha egen definert Game?" + "\n"
					+ "skrive tall på rad og tall for brett,"
					+ " skille med '-' !");
		String svar = in.next();
		String level;
		if (svar.equalsIgnoreCase("d")) {
			level = "3-3";
			}
		else{
			level = svar;
		}
		
		
		ConsoleGame play = new TicTacToeProgram();
		play.init(level);
		play.run();
		in.close();
	}

	// public Integer doLine(String input){
	// int r;
	// //returverdien er null, så er spillet fortsatt igang
	//
	// //verdien er positiv så vant spilleren
	//
	// //verdien er negativ så tapte spilleren
	//
	// //0 så er resultatet udefinert evt. uavgjort
	//
	// return r;
	// }
}
