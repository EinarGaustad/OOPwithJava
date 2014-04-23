package oving6.cardcontainer;

import oving5.Card.Card;

/***
 * Denne oppgaven handler om å lage et felles grensesnitt 
 * for CardDeck og CardHand, laget i oppgaven om 
 * Objekstrukturer - Card-oppgave.
 * @author junjun
 *
 */
public interface CardContainer {
	/***
	 * Denne oppgaven bygger på klasser fra Card-oppgaven. 
	 * Her skal du lage og implementere et grensenitt kalt 
	 * CardContainer, som spesifiserer metoder for lesing 
	 * av samlinger av Card-objekter.
	 * @return
	 */
	public int getCardCount();
	
	public Card getCard(int n);

    public CardContainerIterator iterator();

}
