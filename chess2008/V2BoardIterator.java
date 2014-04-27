package chess2008;

import java.util.Iterator;


public class V2BoardIterator extends V2ArrayIterator implements Iterator<String> {
    
    private static String[] positions = new String[64];
    private V2ArrayIterator   iterator  = new V2ArrayIterator(computePositions());
    
    public static String[] computePositions() {
        if(positions==null){
            int pos=0;
            for(char column = 'a'; column <='h'; column++){
                for (char row='1';row<='8';row++){
                    positions[pos++] = String.valueOf(column)
                            + String.valueOf(row);
                }
            }
        }
        return positions;
    }
    
    public V2BoardIterator() {
        super(computePositions());
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public String next() {
        return iterator.next();
    }

    @Override
    public void remove() {
        
    }
    
}
