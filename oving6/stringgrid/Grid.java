package oving6.stringgrid;

import java.util.ArrayList;

public class Grid {
	private ArrayList<String> grid = new ArrayList<String>();
	private int x_max;
	//private int y_max;
	
	public Grid(int x_max, int y_max){
		this.x_max = x_max;
		//this.y_max = y_max;
		
		for (int i = 0; i < (x_max * y_max); i++){
			grid.add(null);
		}	
	}
	public String getCell(int x, int y){
		int index = calcIndex(x, y);
		return grid.get(index);	
	}
	public void setCell(int x, int y, String value){
		int index = calcIndex(x, y);
		grid.set(index, value);
	}
	private int calcIndex(int x, int y){
		return y*x_max + x;
	}
}
