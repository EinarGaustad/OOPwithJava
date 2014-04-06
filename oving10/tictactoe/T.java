package oving10.tictactoe;

import java.util.ArrayList;

public class T extends TicTacToe implements GridProvider {
    
    private ArrayList<GridListener> listeners;

    private GridProvider            grid;
    
    public T() {
        super();
        listeners = new ArrayList<GridListener>();
        grid = new T();
        initGrid();
    }
    
    public T(int M, int NxN) {
        super(M, NxN);
        listeners = new ArrayList<GridListener>();
        grid = new T();
        initGrid();
    }
    
    // go through all element in grid:
    private void initGrid() {
        for (int row = 0; row < grid.getGridHeight(); row++) {
            for (int column = 0; column < grid.getGridWidth(); column++) {
                // Object element = grid.getGridElement(column, row);
                gridChanged(row, column);
            }
        }
    }
    @Override
    public void setInn(int x, int y) {
        if (sumere % 2 == 0) {
            tabel[x][y] = 'O';
        } else {
            tabel[x][y] = 'X';
        }
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
            listener.gridChanged(this, x, y, getGridWidth(), getGridHeight());
        }
    }
}
