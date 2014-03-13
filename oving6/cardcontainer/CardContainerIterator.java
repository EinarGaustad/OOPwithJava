package oving6.cardcontainer;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	
	//private ArrayList<CardContainer> cards;
	private CardContainer cardcontainer;
	int neste = -1;

	public CardContainerIterator(CardContainer cardcontainer) {
		this.cardcontainer = cardcontainer;
	}

	@Override
	public boolean hasNext() {
		return neste < cardcontainer.getCardCount();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("kan ikke remove!");
	}

	@Override
	public Card next() {
		neste++;
		System.out.println("n"+neste);
		return cardcontainer.getCard(neste);
	}
	

}
