package oving6.stringgrid;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {
    
    private ArrayList<ArrayList<String>> grid;
    
    public StringGridImpl() {
        grid = new ArrayList<ArrayList<String>>();
        init(1, 1);
    }
    
    public StringGridImpl(int row, int column) {
        grid = new ArrayList<ArrayList<String>>();
        init(row, column);
    }
    
    private void init(int row, int column) {
        for (int i = 0; i < row; i++) {
            grid.add(new ArrayList<String>());
            for (int j = 0; j < column; j++) {
                grid.get(i).add(null);
            }
        }
    }
    
    public int getRowCount() {
        return grid.size();
    }
    
    public int getColumnCount() {
        return grid.get(0).size();
    }
    
    public String getElement(int row, int column) {
        return grid.get(row).get(column);
    }
    
    public void setElement(int row, int column, String element) {
        grid.get(row).set(column, element);
    }
    
    @Override
    public Iterator<String> iterator() {
        ArrayList<String> alist = new ArrayList<String>();
        for (ArrayList<String> list : grid) {
            for (String s : list) {
                alist.add(s);
            }
        }
        return alist.iterator();
    }
    
    public String toString() {
        String s = "\n";
        for (ArrayList<String> list : grid) {
            for (String ss : list) {
                s += ss + ", ";
            }
            s += "\n";
        }
        return s + " ---- ";
    }
}
