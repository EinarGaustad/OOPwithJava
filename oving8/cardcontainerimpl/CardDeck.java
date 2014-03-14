package oving8.cardcontainerimpl;

import java.util.ArrayList;

/***
 * CardDeck-klassen inneholder initielt et visst antall kort av de fire
 * kortfargene S', 'H', 'D' og 'C'. Klassen inneholder standardmetoder for å
 * lese hvor mange og hvilke kort og to metoder for endre tilstand. Konstruktør:
 * 
 * @author junjun
 * 
 */
public class CardDeck extends CardContainerImpl implements CardContainer {
	public CardDeck(int n) {
		if (n > super.getMaxCardCount()) {
			throw new IllegalStateException("tillattt max er"
					+ super.getCardCount());
		}else{
			n -= 1;
			cards = new ArrayList<Card>();
			String color = "SHDC";
			for (int j = 0; j < 4; j++) {
				if (n >= 13) {
					for (int m = 0; m < n / 13; m++) {
						for (int i = 0; i < 13; i++) {
							this.cards.add(new Card(color.charAt(j), i + 1));
						}
					}
					for (int i = 0; i < n % 13; i++) {
						this.cards.add(new Card(color.charAt(j), i + 1));
					}
				} else {
					for (int i = 0; i < n; i++) {
						this.cards.add(new Card(color.charAt(j), i + 1));
					}
				}
			}
		}
	}

	public void deal(CardHand c, int n) {
		if (n > this.cards.size()) {
			throw new IllegalArgumentException("feil index!");
		} else if (n > c.getMaxCardCount()) {
			throw new IllegalStateException("tillattt max er"
					+ c.getCardCount());
		} else {
			for (int i = this.cards.size() - 1; i > this.cards.size() - n; i--) {
				c.addCard(this.cards.get(i));
				this.cards.remove(i);
			}
		}
	}

	public void shufflePerfectly() {
		ArrayList<Card> cardsA, cardsB = new ArrayList<Card>();
		int size = cards.size();
		cardsA = (ArrayList<Card>) cards.subList(0, size / 2);
		cardsB = (ArrayList<Card>) cards.subList(size / 2, size);
		int j = 0;
		for (int i = 0; i < size / 2; i++) {
			cards.set(j, cardsA.get(i));
			j++;
			cards.set(j, cardsB.get(i));
			j++;
		}
	}
}
