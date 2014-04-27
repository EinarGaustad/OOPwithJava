package chess2008;

import java.util.Iterator;


public class ArrayIterator implements Iterator<String> {
    
    private String[] elements;
    private int      pos = 0;
    
    public ArrayIterator(String[] elements) {
        this.elements = new String[elements.length];
        System.arraycopy(elements, 0, this.elements, 0, elements.length);
    }
    
    @Override
    public boolean hasNext() {
        return pos < elements.length;
    }
    
    @Override
    public String next() {
        return elements[pos++];
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}