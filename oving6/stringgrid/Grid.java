package oving6.stringgrid;

import java.util.ArrayList;

public class Grid {
    
    private ArrayList<String> grid;
    private int               x_max;
    
    public Grid(int x_max, int y_max) {
        grid = new ArrayList<String>();
        this.x_max = x_max;
        init(x_max, y_max);
    }
    
    private void init(int x_max, int y_max) {
        for (int i = 0; i < (x_max * y_max); i++) {
            grid.add(i, null);
        }
    }
    
    public String getCell(int x, int y) {
        int index = calcIndex(x, y);
        return grid.get(index);
    }
    
    public void setCell(int x, int y, String value) {
        int index = calcIndex(x, y);
        grid.set(index, value);
    }
    
    private int calcIndex(int x, int y) {
        return (y - 1) * x_max + x - 1;
    }
}
