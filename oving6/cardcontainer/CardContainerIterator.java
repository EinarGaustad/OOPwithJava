package oving6.cardcontainer;

import java.util.Iterator;

import oving5.Card.Card;

public class CardContainerIterator implements Iterator<Card>{
	
	private CardContainer cardcontainer;
    private int           neste = -1;

	public CardContainerIterator(CardContainer cardcontainer) {
		this.cardcontainer = cardcontainer;
	}

	@Override
	public boolean hasNext() {
        return neste < cardcontainer.getCardCount() - 1;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("kan ikke remove!");
	}

	@Override
	public Card next() {
		neste++;
        System.out.println("Card next++: " + neste);
		return cardcontainer.getCard(neste);
	}
}
