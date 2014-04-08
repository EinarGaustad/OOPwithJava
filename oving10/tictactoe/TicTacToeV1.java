package oving10.tictactoe;

public class TicTacToeV1 {
	
    protected char[][] tabel  = { // new char [2][2];
								{ ' ', ' ', ' ' }, { ' ', ' ', ' ' },
			{ ' ', ' ', ' ' },	};
    protected int      sumere = 0;

	public char turen() {// kunne dele med to en øke sumere en ruren
		sumere++;
		if (sumere % 2 == 0) {
			return 'O';
		}
		return 'X';
	}
	
	public void setInn(int x, int y) {
		if (sumere % 2 == 0) {
			tabel[x][y] = 'O';
		} else
			tabel[x][y] = 'X';
	}
	
	public boolean isValid(String s) {
		if (s.length() != 2) {
			return false;
		}
		char x = s.charAt(0);
		char y = s.charAt(1);
		if ((x == '0' || x == '1' || x == '2')
				&& (y == '0' || y == '1' || y == '2')) {
			if (tabel[Integer.parseInt("" + x)][Integer.parseInt("" + y)] == ' ') {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {// minst mulig....
		if (vinne()!=' '){
			return "spileren : "+vinne()+" vinne!"+"\n"
					+tabel[0][0]+" | "+tabel[0][1]+" | "+tabel[0][2]+"\n"
					+tabel[1][0]+" | "+tabel[1][1]+" | "+tabel[1][2]+"\n"
					+tabel[2][0]+" | "+tabel[2][1]+" | "+tabel[2][2];
		}
		if (sumere==9){
			return "ingen vinne!"+"\n"
					+tabel[0][0]+" | "+tabel[0][1]+" | "+tabel[0][2]+"\n"
					+tabel[1][0]+" | "+tabel[1][1]+" | "+tabel[1][2]+"\n"
					+tabel[2][0]+" | "+tabel[2][1]+" | "+tabel[2][2];
		}
		return "spileren : "+turen()+"\n"
				+tabel[0][0]+" | "+tabel[0][1]+" | "+tabel[0][2]+"\n"
				+tabel[1][0]+" | "+tabel[1][1]+" | "+tabel[1][2]+"\n"
				+tabel[2][0]+" | "+tabel[2][1]+" | "+tabel[2][2];
	}
	public char vinne(){
		if (tabel[0][0]==tabel[0][1] && tabel[0][1]==tabel[0][2]){
			return tabel[0][0];
		}
		if (tabel[1][0]==tabel[1][1] && tabel[1][1]==tabel[1][2]){
			return tabel[1][0];
		}
		if (tabel[2][0]==tabel[2][1] && tabel[2][1]==tabel[2][2]){
			return tabel[2][0];
		}
		
		if (tabel[0][0]==tabel[1][0] && tabel[1][0]==tabel[2][0]){
			return tabel[0][0];
		}
		if (tabel[0][1]==tabel[1][1] && tabel[1][1]==tabel[2][1]){
			return tabel[0][1];
		}
		if (tabel[0][2]==tabel[1][2] && tabel[1][2]==tabel[2][2]){
			return tabel[0][2];
		}
		
		if (tabel[0][0]==tabel[1][1] && tabel[1][1]==tabel[2][2]){
			return tabel[0][0];
		}
		if (tabel[0][2]==tabel[1][1] && tabel[1][1]==tabel[2][0]){
			return tabel[0][2];
		}
		return ' ';
	}
	public int getSumere(){
		return sumere;
	}
	
}
