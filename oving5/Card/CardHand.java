package oving5.Card;

// import java.util.ArrayList;

/***
 * CardHand-klassen inneholder initielt ingen kort, 
 * og inneholder de samme standardmetodene som CardDeck, 
 * altså getCardCount() og getCard(int), for å lese hvor 
 * mange og hvilke kort den inneholder. I tillegg har den
 * to metoder for å endre tilstand
 * @author junjun
 *
 */
public class CardHand extends CardDeck{
	
	public void addCard(Card nyCard){
		cards.add(nyCard);
	}
	public Card play(int n){
        System.out.println("card play called: " + this.toString() + " : "
                + cards.get(n));
        return cards.remove(n);
	}
    
}
