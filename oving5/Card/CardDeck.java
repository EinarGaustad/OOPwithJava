package oving5.Card;
import java.util.ArrayList;
/***
 * CardDeck-klassen inneholder initielt et visst antall kort 
 * av de fire kortfargene S', 'H', 'D' og 'C'. Klassen inneholder
 *  standardmetoder for å lese hvor mange og hvilke kort og to 
 *  metoder for endre tilstand. Konstruktør:
 * @author junjun
 *
 */
public class CardDeck {
	private ArrayList<Card> cards;
	/***
	 * CardDeck(int n) - fyller kortstokken med de 
	 * n første kortene av hver kortfarge, totalt 
	 * n * 4 kort, med spar 1 som første kort 
	 * (indeks nr. 0), spar 2 som andre (nr. 1), 
	 * spar 3 som tredje (nr. 2), spar 4 som fjerde 
	 * (nr. 3), ..., hjerter 1 som fjortende (nr. 13), 
	 * hjerter 2 som femtende (nr. 4) osv. i.e. først
	 * alle spar, så hjerter, så ruter og så kløver,
	 * alle i stigende rekkefølge. 
	 * @param n
	 */
	private CardHand cardHand = new CardHand();
	public CardDeck(){
		
	}
	public CardDeck(int n){
		n-=1;
		cards = new ArrayList<Card>();
		String color = "SHDC";
		for (int j = 0; j < 4; j++) {
			
			if ( n >= 13 ) {
				for (int m=0; m<n/13; m++){
					for (int i=0; i<13; i++){
						this.cards.add(new Card(color.charAt(j),i+1));
					}
				}
				for (int i=0; i<n%13; i++){ 
					this.cards.add(new Card(color.charAt(j),i+1));	
				}
			}
			else{
			
				for (int i=0; i<n; i++){ 
					this.cards.add(new Card(color.charAt(j),i+1));	
				}
			}
		}
	}
	/***
	 *  
	 * @return
	 * returnerer hvor mange Card-objekter
	 * som CardDeck-objektet inneholder
	 */
	public int getCardCount(){
		return cards.size();
	}
	/***
	 * 
	 * @param n
	 * @return kort nr. n eller utløser et 
	 * IllegalArgumentException hvis n ikke er gyldig
	 */
	public Card getCard(int n){
		if (n>cards.size() || n<0){
			throw new IllegalArgumentException("Feil index!");
		}
		return cards.get(n);
	}
	/***
	 * deal(CardHand, int n) - flytter n kort fra 
	 * kortstokken (CardDeck-objektet) til korthånda
	 * (CardHand-objektet, som er første argument),
	 * ved å ta ett og ett kort med høyeste gyldige
	 * nr., fjerne det fra CardDeck-objektet og legge
	 * det til CardHand-objektet
	 */
	public void deal(CardHand C, int n){
		if (n > cards.size()){
			throw new IllegalArgumentException("feil index!");
		}
		else{
			for (int i = cards.size()-1; i>cards.size()-n; i--){
				cardHand.addCard(cards.get(i));
				cards.remove(i);
			}
		}
	}
	/***
	 * shufflePerfectly() - stokker kortstokken ved
	 * å dele den i to like store deler og flette de
	 * to delene perfekt, slik at kortet på toppen
	 * forblir på toppen og kortet på bunnen forblir
	 * på bunnen
	 */
	public void shufflePerfectly(){
		ArrayList<Card> cardsA, cardsB = new ArrayList<Card>();
		int size = cards.size();
		cardsA = (ArrayList<Card>) cards.subList(0, size/2);
		cardsB = (ArrayList<Card>) cards.subList(size/2, size);
		int j = 0;
		for (int i = 0; i < size/2; i++){
			cards.set(j, cardsA.get(i));
			j++;
			cards.set(j, cardsB.get(i));
			j++;
		}		
	}
}
