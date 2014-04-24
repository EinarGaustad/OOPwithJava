package exam2008sjakk;

import java.util.ArrayList;
import java.util.Iterator;

// import org.hamcrest.internal.ArrayIterator;

public class BoardIterator implements Iterator<String> {
    
    private ArrayList<String> stringPos;
    
    // private ArrayIterator iterator;
    
    // private int next;
    // private int listsize;
    
    /**
     * Anta at det finnes en Iterator<String>-implementasjon kalt BoardIterator
     * som ”generer” alle String-posisjoner ”a1” til ”h8” på brettet (i en
     * eller annen rekkefølge). Bruk BoardIterator til å implementere en metode
     * String findKind(PieceColor pieceColor), som returnerer posisjonen til
     * King-brikken med den angitte pieceColor.
     * 
     * constructor take Board and generate a String position list:
     */
    public BoardIterator(Board board) {
        stringPos = new ArrayList<String>();

        // next = -1;
        // listsize = board.getColumnCount() * board.getRowCount();
        for (int row = board.getRowCount(); row > 0; row--) {
            for (int column = 0; column < board.getColumnCount(); column++) {
                stringPos.add(((char) (column + 'a')) + "" + row);
            }
        }
        // iterator = new ArrayIterator(stringPos);
    }
    
    public ArrayList<String> getPosList() {
        return stringPos;
    }
    // @Override
    // public boolean hasNext() {
    // //make own iterator function
    // return next < listsize - 1;
    // }
    //
    // @Override
    // public String next() {
    // next++;
    // return stringPos.get(next);
    // }
    //
    @Override
    public void remove() {
        throw new UnsupportedOperationException(
                "remove are not supperoted here");
    }

    @Override
    public boolean hasNext() {
        // reuse ArrayList iterator function
        return stringPos.iterator().hasNext();
    }

    @Override
    public String next() {
        return stringPos.iterator().next();
    }

}
