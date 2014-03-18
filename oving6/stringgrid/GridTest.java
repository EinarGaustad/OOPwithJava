package oving6.stringgrid;

import java.util.Iterator;

public class GridTest {
public static void main(String[] args) {
	StringGrid sg = new StringGridImpl(2, 2);
	sg.setElement(0,  0, "00");
	sg.setElement(1,  0, "10");
	sg.setElement(0,  1, "01");
	sg.setElement(1,  1, "11");
	
	StringGridIterator sgi = new StringGridIterator(sg, true);
	
	while(sgi.hasNext())
		System.out.println(sgi.next());
	
	for (String s : sg)
		System.out.println(s);
	
	// Samme som:
	Iterator<String> it = sg.iterator();
	while (it.hasNext())
		System.out.println(it.next());
}
}
