package oving3.encapsulation;

public class LineEditor {
	private String text;
	//private int insertionIndex;
	private int insertionIndex;
	
	public LineEditor(String text, int insertionIndex){
		this.text = text;
		this.insertionIndex = insertionIndex;
		this.sjekkInsert();
	}
	public LineEditor(String text){
		this.text = text;
		insertionIndex = 0;
	}
	public LineEditor(){
		text = "";
		insertionIndex = 0;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getText(){
		return text;
	}
	public void left(){
		insertionIndex -=1;
		this.sjekkInsert();
	}
	public void right(){
		insertionIndex +=1;
		sjekkInsert();
	}
	public void setInsertionIndex(int index){
		insertionIndex = index;
	}
	public int getInsertionIndex(){
		return insertionIndex;
	}
	public void insertString(String s){
		String nyText="";
		nyText+=text.substring(0, insertionIndex);
		nyText+=s;
		nyText+=text.substring(insertionIndex,text.length());
		text = nyText;
		this.right();
		//insertionIndex+=1;
		//sjekkInsert();
	}
	public void deleteLeft(){
		//sjekkInsert();
		if(insertionIndex>0){
			String nyText="";
			nyText+=text.substring(0, insertionIndex-1);
			nyText+=text.substring(insertionIndex);//substring(start)auto til slutt
			text = nyText;
		}
	}
	public void deleteRight(){
		//sjekkInsert();
		if (insertionIndex<text.length()){
			String nyText="";
			nyText+=text.substring(0, insertionIndex);
			nyText+=text.substring(insertionIndex+1,text.length());
			text = nyText;
		}
	}
	public String toString(){
		
		return text.substring(0, insertionIndex)+"|"+
				text.substring(insertionIndex,text.length());
	}
	public void sjekkInsert(){
		if (insertionIndex<0)
			insertionIndex =0;
		else if (insertionIndex>text.length())
			insertionIndex = text.length();
	}
}
