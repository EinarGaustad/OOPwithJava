package oving7.tictactoe;

//import java.util.Stack;

public class test {
	public static void main(String[] args) {
		
		
		
//		TicTacToe t = new TicTacToe();
//		System.out.println(t.toString());
//		
//		
//		TicTacToe t2 = new TicTacToe(5,5);
//		System.out.println(t2.toString());
		
//		Stack<Deck> stack = new Stack<Deck>();
//
//		String x = " |X| ";
//		char c = x.charAt(2);
//		System.out.println(x.charAt(1));
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i);
//			try {
//				int M = Integer.parseInt("11");
//				int NxN = Integer.parseInt("12");
//				System.out.println(M+" " +NxN);
//				break;
//			}catch(NumberFormatException e){
//				System.out.println(e);
//			}
//			if(i==5){
//				break;
//				
//			}
//			System.out.println(i+"b");
//		}
		
		

		// char [] [] tabel = { //new char [2][2];
		// {'X',' ',' '},
		// {' ',' ',' '},
		// {' ',' ',' '},
		// };
		//
		// stack.add(new Deck(tabel, 1));
		// System.out.println(stack.elementAt(0).toString());
		//
		//
		//
		// char [] [] tabel2 = { //new char [2][2];
		// {' ',' ',' '},
		// {' ',' ',' '},
		// {' ',' ','O'},
		// };
		//
		// stack.add(new Deck(tabel2, 2));
		// System.out.println(stack.elementAt(0).toString());
		// System.out.println(stack.elementAt(1).toString());
		// System.out.println(stack.pop());
		// System.out.println(stack.pop());
		// for (int i = 90; i<100; i++){
		// //stack.add(i);
		// int b = i+10;
		// stack.push(b);
		// System.out.println(stack.get((i-90)));
		// System.out.println(stack.firstElement());
		// }
		// for (int i = 0; i<10; i++){
		// System.out.println(stack.pop());
		// }

	}
	public char x(){
		char [][] tabel =new char [5][5];
		int NxN = 5;
		int M = 5;
		boolean isNxN = true;
		if (isNxN) {
			for (int i = 0; i < NxN; i++) {
				//return ' ';
				int x = 0;
				int o = 0;
				for (int j = 0; j < NxN; j++) {

					// sjekk rad > =M
					if (tabel[i][j] == 'X') {
						x++;
						o = 0;
						if (x >= M) {
							return 'X';
						}
					}
					if (tabel[i][j] == 'O') {
						o++;
						x = 0;
						if (o >= M) {
							return 'O';
						}
					}

					// sjekk colum > = M
					if (tabel[j][i] == 'X') {
						x++;
						o = 0;
						if (x >= M) {
							return 'X';
						}
					}
					if (tabel[j][i] == 'O') {
						o++;
						x = 0;
						if (o >= M) {
							return 'O';
						}
					}

					// sjekk diagonal >= M
				}
				
			}
			
		}
		return ' ';
	}
}
