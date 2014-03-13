package oving1;

public class Location {
	int x=0;
	int y=0;
	
	public void up(){
		y+=1;
	}
	public void down(){
		y-=1;
	}
	public void left(){
		x-=1;
	}
	public void right(){
		x+=1;
	}
	public String toString(){
		return "x: "+x+"   y: "+y;
		//return xy;
	}
}
