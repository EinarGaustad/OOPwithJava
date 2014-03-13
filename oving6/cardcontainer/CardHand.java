package oving6.cardcontainer;

import java.util.ArrayList;

/***
 * CardHand-klassen inneholder initielt ingen kort, 
 * og inneholder de samme standardmetodene som CardDeck, 
 * altså getCardCount() og getCard(int), for å lese hvor 
 * mange og hvilke kort den inneholder. I tillegg har den
 * to metoder for å endre tilstand
 * @author junjun
 *
 */
public class CardHand extends CardDeck implements CardContainer{
	private ArrayList<Card> cards;
	//private CardDeck cardDeck = new CardDeck();
	public CardHand(){
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card nyCard){
		cards.add(nyCard);
	}
	public Card play(int n){
		return cards.remove(n);
	}
	
}
