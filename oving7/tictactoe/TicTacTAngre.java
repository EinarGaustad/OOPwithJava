package oving7.tictactoe;

import java.util.Stack;

public class TicTacTAngre extends TicTacToe implements Ttt {
	private Stack<Deck>	stack	= new Stack<Deck>();
	private Stack<Deck>	redo	= new Stack<Deck>();

	public TicTacTAngre(int M, int NxN) {
		super(M, NxN);
	}

	public TicTacTAngre() {
		super();
	}

	public void undo() {
		if (stack.size() == 0) {
			System.out.println("kan ikke angre mer!");
			super.init();
		} else {
			Deck nydeck = stack.pop();
			super.setNy(nydeck.getTabel(), nydeck.getM(), nydeck.getNxN(),
					nydeck.getSumere());
			redo.add(nydeck);
		}
	}

	public void redo() {
		if (redo.size() == 0) {
			System.out.println("stacken er tommet!");
		} else {
			Deck redoDeck = redo.pop();
			super.setNy(redoDeck.getTabel(), redoDeck.getM(),
					redoDeck.getNxN(), redoDeck.getSumere());
		}
	}

	public void loadgame(char[][] tabel, int M, int NxN, int sumere) {
		super.setNy(tabel, M, NxN, sumere);
	}

	public void setInn(String s) {
		int x = Integer.parseInt("" + s.charAt(0));
		int y = Integer.parseInt("" + s.charAt(1));
		super.setInn(x, y);
		int tabelL = getTabel().length;
		char[][] t = new char[tabelL][tabelL];
		for (int i = 0; i < tabelL; i++) {
			for (int j = 0; j < tabelL; j++) {
				t[i][j] = getTabel()[i][j];
			}
		}
		int i = 0;
		i = getSumere();
		stack.add(new Deck(t, getM(), getNxN(), i));
	}
}
