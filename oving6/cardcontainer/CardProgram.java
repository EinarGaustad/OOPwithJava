package oving6.cardcontainer;

import java.util.Iterator;

public class CardProgram {
public static void main(String[] args) {
	CardContainer cc = new CardDeck();
	
	Iterator<Card> it = cc.iterator();
	while(it.hasNext())
		System.out.println(it.next());
	
//	for (Card c : cc)
//		System.out.println(c);
}
}
