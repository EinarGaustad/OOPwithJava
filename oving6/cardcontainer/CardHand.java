package oving6.cardcontainer;

import oving5.Card.Card;

/***
 * CardHand-klassen inneholder initielt ingen kort, og inneholder de samme
 * standardmetodene som CardDeck, altså getCardCount() og getCard(int), for å
 * lese hvor mange og hvilke kort den inneholder. I tillegg har den to metoder
 * for å endre tilstand
 * 
 * @author junjun
 * 
 */
public class CardHand extends CardDeck implements CardContainer {
    
    public CardHand(int suitSize) {
        super(suitSize);
    }

    public CardHand() {
        super();
    }

    public void addCard(Card nyCard) {
        cards.add(nyCard);
    }
    
    public Card play(int n) {
        return cards.remove(n);
    }
}
