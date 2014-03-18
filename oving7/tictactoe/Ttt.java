package oving7.tictactoe;

public interface Ttt {

	char vinne();

	boolean isValid(String s);

	int getSumere();

	void setInn(String s);

	void undo();

	void redo();

	void init();

	void loadgame(char[][] tabel, int M, int NxN, int sumere);

	char[][] getTabel();

	int getBlock();

	int getM();

	int getNxN();
}
