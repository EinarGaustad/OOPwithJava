package oving6.cardcontainer;

import oving5.Card.Card;

/***
 * CardDeck-klassen inneholder initielt et visst antall kort av de fire
 * kortfargene S', 'H', 'D' og 'C'. Klassen inneholder standardmetoder for å
 * lese hvor mange og hvilke kort og to metoder for endre tilstand. Konstruktør:
 * 
 * @author junjun
 * 
 */
public class CardDeck extends oving5.Card.CardDeck implements CardContainer {
    
    public CardDeck(int suitSize) {
        super(suitSize);
    }
    
    public CardDeck() {
        super();
    }

    @Override
    public Card getCard(int n) {
        if (n > cards.size() || n < 0) {
            throw new IllegalArgumentException("Feil index!");
        }
        return cards.get(n);
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Card card : cards) {
            s += card.toString() + ", ";
        }
        return s;
    }
    
    @Override
    public CardContainerIterator iterator() {
        return new CardContainerIterator(this);
    }
}
