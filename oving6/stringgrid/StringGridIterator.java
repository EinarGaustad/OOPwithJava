package oving6.stringgrid;

import java.util.Iterator;

/***
Denne klassen implementere grensesnittet 
Iterator<String>, siden StringGrid inneholder String-objekter
 * @author junjun
 *
 */
public class StringGridIterator implements Iterator<String>{
	
	private StringGrid strenger;
	private int neste = 0;
	
	public StringGridIterator(StringGrid strenger, boolean b){
		if (b){
			this.strenger = strenger;
		}
		else{
			StringGrid nystrenger = new StringGridImpl();
			for (int i =0; i < strenger.getRowCount(); i++){
				for (int j = 0; j<strenger.getColumnCount(); j++){
					nystrenger.setElement(i, j, strenger.getElement(strenger.getRowCount()-i, strenger.getColumnCount()-j));
				}
			}
			this.strenger = nystrenger;
		}
	}

	@Override
	public boolean hasNext() {
		return neste < strenger.getColumnCount()*strenger.getRowCount();
	}

	@Override
	public String next() {
		int row =neste/strenger.getColumnCount(); 
		int column =neste%strenger.getColumnCount();
		neste++;
		return strenger.getElement(row, column);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Unsupported Operation!");
	}
}
