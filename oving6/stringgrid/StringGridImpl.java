package oving6.stringgrid;

import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid{
	
	//private Grid grid;
	private ArrayList<ArrayList<String>> grid;
	
//	list [][] 
	
	public StringGridImpl(){
		grid = new ArrayList<ArrayList<String>>();
	}
//	public StringGridImpl(int row, int column, String element) {
//		grid = new ArrayList<ArrayList<String>>();
//		for (int i = 0; i < row; i++) {
//			grid.add(new ArrayList<String>());
//			for (int j = 0; j < column; j++) {
//				grid.get(i).add("");
//			}
//		}
//		//if (grid.get(row) )
//		grid.get(row).set(column, element);
//	}
	public StringGridImpl(int row, int column) {
		grid = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < row; i++) {
			grid.add(new ArrayList<String>());
			for (int j = 0; j < column; j++) {
				grid.get(i).add("");
			}
		}
		//grid.get(row).set(column, null);
	}
	
	public int getRowCount() {
		return grid.size();
	}

//	public int getColumnCount(int row) {
//		return grid.get(row).size();
//	}
	public int getColumnCount() {
		return grid.get(0).size();
	}

	public String getElement(int row, int column) {
		return grid.get(row-1).get(column-1);
	}

	public void setElement(int row, int column, String element) {
		grid.get(row-1).set(column-1, element);
	}
	@Override
	public Iterator<String> iterator() {
		StringGridIterator b = new StringGridIterator(this, true);
		return b;
	}
	
}
