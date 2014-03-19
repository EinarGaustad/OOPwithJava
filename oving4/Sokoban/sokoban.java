package oving4.Sokoban;

import java.util.Scanner;

public class sokoban {
	
	public static void main(String[] args) {
		Rote sokoban = new Rote();
		Scanner in = new Scanner(System.in);
		boolean stopp = false;
		outer: while (!stopp) {
			System.out.println(sokoban.toString());
			char flytteTegn;
			if (!sokoban.vinne()) {
				boolean nyVerdi = false;
				do {
					in = new Scanner(System.in);
					String flytte = in.next();
					flytteTegn = flytte.toLowerCase().charAt(0);
					if (sokoban.stopp(flytteTegn)) {
						break outer;
					}
					if (!sokoban.isValid(flytteTegn)) {
						nyVerdi = true;
						System.out
								.println("feil inndato, kjekk skrive inn igjen! "
										+ "a, s, d og w (p for stopp)");
					} else {
						nyVerdi = false;
					}
				} while (nyVerdi);
				sokoban.flytte(flytteTegn);
			} else
				stopp = true;
		}
		in.close();
		if (sokoban.vinne()) {
			System.out.println("! Gratulerer! Du har vinnet !");
		} else {
			System.out.println("! Game Over !");
		}
	}
}
