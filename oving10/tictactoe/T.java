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
                gridChanged(row, column);
            }
        }
    }

    @Override
    public void setNy(char[][] tabel, int M, int NxN, int sumere) {
        super.setNy(tabel, M, NxN, sumere);
        initGrid();
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
        return tabel[y][x];
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
            listener.gridChanged(this, y, x, 1, 1);
        }
    }
}
