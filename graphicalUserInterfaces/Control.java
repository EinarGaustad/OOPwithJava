package graphicalUserInterfaces;

import java.util.ArrayList;


public class Control {
    
    private int[]       table;
    
    private ArrayList<Elements> components;
    
    /**
     * @param table
     * @param components
     */
    public Control(int[] table) {
        this.table = table;
    }
    
    public int[] getTable() {
        return table;
    }
    
    public void setTable(int[] table) {
        this.table = table;
    }
    
    public ArrayList<Elements> getComponents() {
        return components;
    }
    
    public void setComponents(ArrayList<Elements> components) {
        this.components = components;
    }

}
