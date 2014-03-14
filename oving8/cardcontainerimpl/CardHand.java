package oving8.cardcontainerimpl;

import java.util.ArrayList;

/***
 * CardHand-objekter inneholder initielt ingen kort, og klassen inneholder de
 * samme standardmetodene som CardDeck, altså getCardCount() og getCard(int),
 * for å lese hvor mange og hvilke kort den inneholder. I tillegg har den to
 * metoder for å endre tilstand:
 * 
 * addCard(Card) - legger argumentet til dette CardHand-objektet play(int n) -
 * returnerer og fjerner kort nr. n (første kort har nr. 0) fra dette
 * CardHand-objektet (som om det ble spilt ut)
 * 
 * @author junjun
 * 
 */
public class CardHand extends CardContainerImpl implements CardContainer {

	public CardHand() {
		cards = new ArrayList<Card>();
	}

	public CardHand(int maxCard) {
		cards = new ArrayList<Card>();
		super.maxCardCount(maxCard);
	}

	public void addCard(Card nyCard) {
		if (cards.size() >= super.getMaxCardCount()) {
			throw new IllegalStateException("max card er "
					+ super.getMaxCardCount());
		}
		cards.add(nyCard);
	}

	public Card play(int n) {
		return cards.remove(n);
	}

	public int getCardCount() {
		return cards.size();
	}
}
