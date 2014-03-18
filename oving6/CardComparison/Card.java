package oving6.CardComparison;

public class Card implements Comparable<Object>{
	/***
	 * Card-klassen er en såkalt verdiklasse, som kodes slik at objektene
	 *  ikke kan endres etter at de er opprettet. Et Card-objekt har 
	 *  en kortfarge, som er en av bokstavene 'S' (for spades), 
	 *  'H' (for hearts), 'D' (for diamonds) og 'C' (for clubs), 
	 *  og tallverdi, som er et heltall mellom 1 (ess) og 13 (konge). 
	 *  Følgende metoder må implementeres:
	 */
	private char	cardColor;
	private int		cardNumber;
	
	/***
	 * Card(char, int) - konstruktøren initialiserer kortfarge
	 *  og tallverdi med henholdsvis første og andre argument.
	 *  Konstruktøren må utløse unntak av typen 
	 *  IllegalArgumentException hvis en (eller begge) av 
	 *  disse verdiene er ugyldige.
	 * @param cardColor
	 * @param cardNumber
	 */
	public Card(char cardColor, int cardNumber){
		if (isValid(cardColor, cardNumber)){
			this.cardColor = cardColor;
			this.cardNumber= cardNumber;
		}
		else{
			throw new IllegalArgumentException("Feil verdi !");
		}
	}
	public boolean isValid(char cardColor, int cardNumber){
		String color = "SHDC";
		//String card = ""+cardColor;
		if (color.indexOf(cardColor) > -1 && (cardNumber>0 && cardNumber<14)){
			return true;
		}
		return false;
	}
	/***
	 * returnerer kortfargen som en char, 
	 * en av 'S', 'H', 'D' eller 'C'
	 * @return
	 */
	public char getSuit(){
		return cardColor;
	}
	/***
	 * 
	 * @return tallverdien
	 */
	public int getFace(){
		return cardNumber;
	}
	/***
	 * @return toString()
	 */
	public String toString(){
		return ""+cardColor+cardNumber;
	}
	
//	public int compareTo(Card card){
//		String SUIT = "SHDC";
//		
//		int diff = SUIT.
//	}
	public int compareTo(Object o) {
		Card other = (Card) o;
		String color = "SHDC";
		if (color.indexOf(""+this.cardColor) > (color.indexOf(""+other.cardColor))){
			return 1;
		}
		if (color.indexOf(""+this.cardColor) < (color.indexOf(""+other.cardColor))){
			return -1;
		}
		else {
			if ( this.cardNumber > other.cardNumber){
				return 1;
			}
			if ( this.cardNumber < other.cardNumber){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
}
