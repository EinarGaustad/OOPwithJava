package oving1;

public class lineeditortest1 {
	public static void main(String[] args){
		LineEditor edtest = new LineEditor("abcdefgh",-5);
		System.out.println(edtest.toString());
		
		edtest.insertString("x");
		System.out.println(edtest.toString());
		
		edtest.left();
		System.out.println(edtest.toString());
		
		//edtest.insertionIndex = -56;
		
		edtest.right();
		System.out.println(edtest.toString());
		
		edtest.deleteLeft();
		System.out.println(edtest.toString());
		
		edtest.deleteRight();
		System.out.println(edtest.toString());
	}
}
