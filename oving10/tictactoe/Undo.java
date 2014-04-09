package oving10.tictactoe;

import java.util.Stack;

public class Undo extends T {
    
    private Stack<Deck> stack = new Stack<Deck>();
    private Stack<Deck> redo  = new Stack<Deck>();
    
    public Undo(int M, int NxN) {
        super(M, NxN);
    }
    
    public Undo() {
        super();
    }

    public String undo() {
        String message = null;
        if (stack.size() == 0) {
            // System.out.println("kan ikke angre mer!");
            super.init();
            message = "cannot undo again!";
        } else {
            Deck nydeck = stack.pop();
            super.setNy(nydeck.getTabel(), nydeck.getM(), nydeck.getNxN(),
                    nydeck.getSumere());
            redo.add(nydeck);
        }
        return message;
    }

    public String redo() {
        String message = null;
        if (redo.size() == 0) {
            message = "stack is empty!";
            // System.out.println("stacken er tommet!");
        } else {
            Deck redoDeck = redo.pop();
            super.setNy(redoDeck.getTabel(), redoDeck.getM(),
                    redoDeck.getNxN(), redoDeck.getSumere());
        }
        return message;
    }
    
    public void loadgame(char[][] tabel, int M, int NxN, int sumere) {
        super.setNy(tabel, M, NxN, sumere);
    }
    
    @Override
    public void setInn(int x, int y) {
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
