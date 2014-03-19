package oving4.Sokoban;

public class Brett {
	
	private char[][]	board	= {
			{'#', '#', '#', '#', '#', '#', '#'},
			{'#', '.', '@', ' ', '#', ' ', '#'},
			{'#', '$', '*', ' ', '$', ' ', '#'},
			{'#', ' ', ' ', ' ', '$', ' ', '#'},
			{'#', ' ', '.', '.', ' ', ' ', '#'},
			{'#', ' ', ' ', '*', ' ', ' ', '#'},
			{'#', '#', '#', '#', '#', '#', '#'},
	};
	
	public char get(int i, int j) {
		return board[i][j];
	}
	
	public void set(int i, int j, char nyC) {
		board[i][j] = nyC;
	}
	
	public int length() {
		return board.length;
	}
	
	public int length(int i) {
		return board[i].length;
	}
	
	public String toString() {
		String skrivUt = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				skrivUt += board[i][j];
			}
			skrivUt += "\n";
		}
		skrivUt += "# vegg; . mål; $ boks; * boks på mål; @ spiller;"
				+ "+ spiller på mål; ' ' tomt felt;  " + "\n"
				+ "a, s, d og w, for henholdsvis "
				+ "venstre (vest), ned (sør), høyre (øst) og opp (nord)";
		return skrivUt;
	}
}