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
    
    /**
     * 
     * @param stringgrid
     * @param b
     *            konstruktør som tar inn StringGrid-objektet som
     *            StringGridIterator-klassen skal iterere over i tillegg til en
     *            logisk verdi som angir om iterasjonen skal være bortover først
     *            (rowMajor=true) eller nedover først (rowMajor=false).
     */
    public StringGridIterator(StringGrid stringgrid, boolean b) {
        if (b) {
            this.stringgrid = stringgrid;
        } else {
            StringGrid newsg = new StringGridImpl();
            for (int i = 0; i < stringgrid.getRowCount(); i++) {
                for (int j = 0; j < stringgrid.getColumnCount(); j++) {
                    newsg.setElement(i, j, stringgrid.getElement(
                            stringgrid.getRowCount() - i,
                            stringgrid.getColumnCount() - j));
                }
            }
            this.stringgrid = newsg;
        }
    }
    
    @Override
    public boolean hasNext() {
        return next < stringgrid.getColumnCount() * stringgrid.getRowCount()
                - 1;
    }
    
    @Override
    public String next() {
        
        ArrayList<String> alist = new ArrayList<String>();
        for (int i = 0; i < stringgrid.getRowCount(); i++) {
            for (int j = 0; j < stringgrid.getColumnCount(); j++) {
                alist.add(stringgrid.getElement(i, j));
            }
        }
        // int row = next / stringgrid.getColumnCount();
        // int column = next % stringgrid.getColumnCount();
        next++;
        System.out.println("stringgrid colum: " + stringgrid.getColumnCount()
                + " row:  "
                + " next: " + next);
        return alist.get(next);
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Unsupported Operation!");
    }
}
