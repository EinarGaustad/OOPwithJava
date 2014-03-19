package oving4.Sokoban;

public class Rote {
	
	private Brett	spille	= new Brett();
	private boolean	aDot	= false;
	
	public void flytte(char flytteTil) {
		int x = hvor('@')[0];
		int y = hvor('@')[1];
		int i = x;
		int j = y;
		switch (flytteTil) {
			case 'a':
				j -= 1;
				break;
			case 's':
				i += 1;
				break;
			case 'd':
				j += 1;
				break;
			case 'w':
				i -= 1;
				break;
		}
		// 1kan flytte til: ' ', '.', '$'
		// 2. '#', '*'
		if (kanFlytte(i, j)) {
			if (spille.get(i, j) == ' ') {// ' '
				spille.set(i, j, '@');
				if (aDot) {
					spille.set(x, y, '.');
					aDot = false;
				} else {
					spille.set(x, y, ' ');
				}
			}
			if (spille.get(i, j) == '.') {
				spille.set(i, j, '@');
				if (aDot) {
					spille.set(x, y, '.');
					aDot = false;
				} else {
					spille.set(x, y, ' ');
				}
				aDot = true;
			}
			if (spille.get(i, j) == '$') {
				int m = nextTegn(i, j, x, y)[0];
				int n = nextTegn(i, j, x, y)[1];
				if (spille.get(m, n) == ' ') {
					spille.set(m, n, '$');
					spille.set(i, j, '@');
					if (aDot) {
						spille.set(x, y, '.');
						aDot = false;
					} else {
						spille.set(x, y, ' ');
					}
				}
				if (spille.get(m, n) == '.') {
					spille.set(m, n, '*');
					spille.set(i, j, '@');
					if (aDot) {
						spille.set(x, y, '.');
						aDot = false;
					} else {
						spille.set(x, y, ' ');
					}
				}
			}
		}
	}
	
	public int[] nextTegn(int i, int j, int x, int y) {
		int[] table = { 0, 0 };
		if (i == x) {
			if (j < y) {
				table[0] = i;
				table[1] = j - 1;
				return table;
			}
			if (j > y) {
				table[0] = i;
				table[1] = j + 1;
				return table;
			}
		}
		if (j == y) {
			if (i < x) {
				table[0] = i - 1;
				table[1] = j;
				return table;
			}
			if (i > x) {
				table[0] = i + 1;
				table[1] = j;
				return table;
			}
		}
		return table;
	}
	
	public boolean kanFlytte(int i, int j) {
		if (spille.get(i, j) == '#' || spille.get(i, j) == '*') {
			return false;
		}
		return true;
	}
	
	public boolean stopp(char inn) {
		if (inn == 'p') {
			return true;
		}
		return false;
	}
	
	public boolean isValid(char inn) {
		if (inn == 'a' || inn == 's' || inn == 'd' || inn == 'w') {
			return true;
		}
		return false;
	}
	
	public boolean vinne() {
		if (aDot) {
			return false;
		}
		if (hvor('.')[0] == 0 && hvor('.')[1] == 0) {
			return true;
		}
		return false;
	}
	
	public int[] hvor(char tegn) {
		int[] xy = { 0, 0 };
		outer: for (int i = 0; i < spille.length(); i++) {
			for (int j = 0; j < spille.length(); j++) {
				if (spille.get(i, j) == tegn) {
					xy[0] = i;
					xy[1] = j;
					break outer;
				}
				;
			}
		}
		return xy;
	}
	
	public String toString() {
		return spille.toString();
	}
}