package oving2.Stack;
import java.util.ArrayList;
public class Stack {
	ArrayList<String> list=new ArrayList<String>();//Constructs an empty list with the specified initial capacity100.
	
	public void push(String steng){
		list.add(steng);
	}
	public String pop(){
		int size=list.size();
		if (size==0)
			return null;
		String ut=(String)list.get(size-1);
		list.remove(size-1);
		return ut;
	}
	public String peek(int pindex){
		//pindex-=1;
		int size=getSize();
		if (size<pindex||pindex<0)
			return null;
		else 
			return list.get(size-pindex-1);
	}
	public int getSize(){	
		return list.size();
	}
	public String toString(){
		String ut="";
		for(int i=0; i<getSize();i++)
			//ut+=list.get(i)+'\n';
			ut+=peek(i)+'\n';
		return ut;
	}
}
