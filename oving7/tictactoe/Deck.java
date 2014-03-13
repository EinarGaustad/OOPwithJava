package oving7.tictactoe;

public class Deck {
	private int			sumere	= 0;
	private int			M;
	private int			NxN;
	private char[][]	tabel;

	public Deck() {
	}

	public Deck(char[][] tabel, int M, int NxN, int sumere) {
		this.tabel = tabel;
		this.sumere = sumere;
		this.M = M;
		this.NxN = NxN;
	}

	public void setTabel(char[][] tabel) {
		this.tabel = tabel;
	}

	public char[][] getTabel() {
		return tabel;
	}

	public int getM() {
		return M;
	}

	public int getNxN() {
		return NxN;
	}

	public void setSumere(int sumere) {
		this.sumere = sumere;
	}

	public int getSumere() {
		return sumere;
	}

	public String toString() {
		int NxN = getTabel().length;
		String s = "";
		for (int i = 0; i < NxN; i++) {
			s += "\n" + " | ";
			for (int j = 0; j < NxN; j++) {
				s += tabel[i][j] + " | ";
			}
		}
		return s;
	}
}
