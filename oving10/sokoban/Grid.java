package oving10.sokoban;

import java.util.ArrayList;

public class Grid implements GridProvider {
    
    // Tegn Betydning Utskrift
    // '#' vegg
    // '.' mål
    // '$' boks
    // '*' boks på mål
    // '@' spiller
    // '+' spiller på mål
    // ' ' tomt felt
    
    private char[][]                board;
    private ArrayList<GridListener> listener;
    
    public Grid() {
        listener = new ArrayList<GridListener>();
    }
    
    public Grid(String level) {
        listener = new ArrayList<GridListener>();
        init(level);
    }
    
    public void init(String level) {
        if (level.contains("1")) {
            board = new char[12][7];
            char[][] b = { { '#', '#', '#', '#', '#', '#', '#' },
                    { '#', '.', '@', ' ', '#', ' ', '#' },
                    { '#', '$', '*', ' ', '$', ' ', '#' },
                    { '#', ' ', ' ', ' ', '$', ' ', '#' },
                    { '#', ' ', '.', '.', ' ', ' ', '#' },
                    { '#', ' ', ' ', '*', ' ', ' ', '#' },
                    { '#', '.', '@', ' ', '#', ' ', '#' },
                    { '#', '$', '*', ' ', '$', ' ', '#' },
                    { '#', ' ', ' ', ' ', '$', ' ', '#' },
                    { '#', ' ', '.', '.', ' ', ' ', '#' },
                    { '#', ' ', ' ', '*', ' ', ' ', '#' },
                    { '#', '#', '#', '#', '#', '#', '#' }, };
            this.board = b;
        } else if (level.contains("2")) {
            board = new char[9][13];
            char[][] b = {
                    { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
                            '#', '#' },
                    { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                            ' ', '#' },
                    { '#', ' ', ' ', '.', '.', '.', ' ', '.', '.', '.', ' ',
                            ' ', '#' },
                    { '#', ' ', ' ', '*', '$', '$', ' ', '$', '.', '$', ' ',
                            ' ', '#' },
                    { '#', ' ', '$', '*', '+', '$', ' ', '$', '*', '$', '$',
                            ' ', '#' },
                    { '#', ' ', ' ', '*', '$', '$', ' ', '$', '.', '$', ' ',
                            ' ', '#' },
                    { '#', ' ', '.', '.', '.', ' ', ' ', ' ', '.', ' ', ' ',
                            ' ', '#' },
                    { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
                            ' ', '#' },
                    { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
                            '#', '#' }, };
            this.board = b;
        } else {
            board = new char[7][7];
            char[][] b = { { '#', '#', '#', '#', '#', '#', '#' },
                    { '#', '.', '@', ' ', '#', ' ', '#' },
                    { '#', '$', '*', ' ', '$', ' ', '#' },
                    { '#', ' ', ' ', ' ', '$', ' ', '#' },
                    { '#', ' ', '.', '.', ' ', ' ', '#' },
                    { '#', ' ', ' ', '*', ' ', ' ', '#' },
                    { '#', '#', '#', '#', '#', '#', '#' }, };
            this.board = b;
        }
    }
    
    public char[][] getGridTable() {
        return board;
    }
    public void loadGrid(char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                gridChanged(i, j);
            }
        }
    }
    
    public char getElement(int i, int j) {
        return board[i][j];
    }
    
    public void setIn(int i, int j, char nyC) {
        board[i][j] = nyC;
        gridChanged(i, j);
    }
    
    public String toString() {
        String skrivUt = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                skrivUt += board[i][j];
            }
            skrivUt += "\n";
        }
        return skrivUt;
    }
    
    @Override
    public int getGridWidth() {
        return board[0].length;
    }
    
    @Override
    public int getGridHeight() {
        return board.length;
    }
    
    @Override
    public Object getGridElement(int x, int y) {
        return board[y][x];
    }
    
    @Override
    public void addGridListener(GridListener listener) {
        if (!this.listener.contains(listener)) {
            this.listener.add(listener);
        }
    }
    
    @Override
    public void removeGridListener(GridListener listener) {
        if (this.listener.contains(listener)) {
            this.listener.remove(listener);
        }
    }
    
    public void gridChanged(int x, int y) {
        for (GridListener listener : this.listener) {
            listener.gridChanged(this, y, x, 1, 1);
        }
    }
}
