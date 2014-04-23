package oving6.stringgrid;

import java.util.ArrayList;
import java.util.Iterator;

/***
 * Denne klassen implementere grensesnittet Iterator<String>, siden StringGrid
 * inneholder String-objekter
 * 
 * @author junjun
 * 
 */
public class StringGridIterator implements Iterator<String> {
    
    private StringGrid stringgrid;
    private int        next = -1;
    private boolean    rowMajor;
    
    /**
     * 
     * @param stringgrid
     * @param rowMajor
     *            konstruktør som tar inn StringGrid-objektet som
     *            StringGridIterator-klassen skal iterere over i tillegg til en
     *            logisk verdi som angir om iterasjonen skal være bortover først
     *            (rowMajor=true) eller nedover først (rowMajor=false).
     */
    public StringGridIterator(StringGrid stringgrid, boolean rowMajor) {
        this.stringgrid = stringgrid;
        this.rowMajor = rowMajor;

    }
    
    @Override
    public boolean hasNext() {
        System.out.println("string grid size:  " + stringgrid.getColumnCount()
                * stringgrid.getRowCount() + " hasnext: " + next);
        return next < stringgrid.getColumnCount() * stringgrid.getRowCount()
                - 1;
    }
    
    @Override
    public String next() {
        next++;
        ArrayList<String> alist;
        if (rowMajor) {
            alist = new ArrayList<String>();
            for (int i = 0; i < stringgrid.getRowCount(); i++) {
                for (int j = 0; j < stringgrid.getColumnCount(); j++) {
                    alist.add(stringgrid.getElement(i, j));
                }
            }
        } else {
            alist = new ArrayList<String>();
            for (int j = 0; j < stringgrid.getColumnCount(); j++) {
                for (int i = 0; i < stringgrid.getRowCount(); i++) {
                    alist.add(stringgrid.getElement(i, j));
                }
            }
        }
        System.out.println("stringgrid colum: " + stringgrid.getColumnCount()
                + " row:  " + stringgrid.getRowCount() + " next: " + next
                + " alist size: " + alist.size());
        
        return alist.get(next);
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Unsupported Operation!");
    }
}
