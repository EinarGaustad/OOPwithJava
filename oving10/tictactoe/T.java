package oving10.tictactoe;

import java.util.ArrayList;

public class T extends TicTacToe implements GridProvider {
    
    private ArrayList<GridListener> listeners;

    private GridProvider            grid;
    
    public T() {
        super();
        listeners = new ArrayList<GridListener>();
        grid = this;
    }
    
    public T(int M, int NxN) {
        super(M, NxN);
        listeners = new ArrayList<GridListener>();
        grid = this;
    }
    
    // go through all element in grid:
    public void initGrid() {
        for (int row = 0; row < grid.getGridHeight(); row++) {
            for (int column = 0; column < grid.getGridWidth(); column++) {
                // Object element = grid.getGridElement(column, row);
                gridChanged(column, row);
            }
        }
    }
    @Override
    public void setNy(char[][] tabel, int M, int NxN, int sumere) {
        // super.setNy(tabel, M, NxN, sumere);
        // initGrid();
        this.sumere = sumere;
        this.M = M;
        this.NxN = NxN;
        init();
        for (int i = 0; i < tabel.length; i++) {
            for (int j = 0; j < tabel.length; j++) {
                this.tabel[i][j] = tabel[i][j];
                gridChanged(i, j);
            }
        }
    }
    
    @Override
    public void setInn(int x, int y) {
        super.setInn(x, y);
        gridChanged(x, y);
    }

    @Override
    public int getGridWidth() {
        return tabel[0].length;
    }
    
    @Override
    public int getGridHeight() {
        return tabel.length;
    }
    
    @Override
    public Object getGridElement(int x, int y) {
        System.out.println("x y: " + x + " " + y);
        return tabel[x][y];
    }
    
    @Override
    public void addGridListener(GridListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
    
    @Override
    public void removeGridListener(GridListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }
    
    public void gridChanged(int x, int y) {
        for (GridListener listener : listeners) {
            listener.gridChanged(this, x, y, 1, 1);// getGridWidth(),
                                                   // getGridHeight());
        }
    }
}
