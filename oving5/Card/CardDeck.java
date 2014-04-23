package oving5.Card;

import java.util.ArrayList;

/***
 * CardDeck-klassen inneholder initielt et visst antall kort av de fire
 * kortfargene S', 'H', 'D' og 'C'. Klassen inneholder standardmetoder for å
 * lese hvor mange og hvilke kort og to metoder for endre tilstand. Konstruktør:
 * 
 * @author junjun
 * 
 */
public class CardDeck {
    
    protected ArrayList<Card> cards;
    /***
     * CardDeck(int n) - fyller kortstokken med de n første kortene av hver
     * kortfarge, totalt n * 4 kort, med spar 1 som første kort (indeks nr. 0),
     * spar 2 som andre (nr. 1), spar 3 som tredje (nr. 2), spar 4 som fjerde
     * (nr. 3), ..., hjerter 1 som fjortende (nr. 13), hjerter 2 som femtende
     * (nr. 4) osv. i.e. først alle spar, så hjerter, så ruter og så kløver,
     * alle i stigende rekkefølge.
     * 
     * @param n
     */
    public CardDeck() {
        cards = new ArrayList<Card>();
    }

    public CardDeck(int suitSize) {
        cards = new ArrayList<Card>();
        String suit = "SHDC";
        for (int s = 0; s < suit.length(); s++) {
            for (int m = 0; m < (suitSize / 13); m++) {
                for (int i = 1; i <= 13; i++) {
                    this.cards.add(new Card((char) suit.charAt(s), i));
                }
            }
            for (int i = 1; i <= (suitSize % 13); i++) {
                this.cards.add(new Card(suit.charAt(s), i));
            }
        }
    }
    
    /***
     * 
     * @return returnerer hvor mange Card-objekter som CardDeck-objektet
     *         inneholder
     */
    public int getCardCount() {
        return cards.size();
    }
    
    /***
     * 
     * @param n
     * @return kort nr. n eller utløser et IllegalArgumentException hvis n ikke
     *         er gyldig
     */
    public Card getCard(int n) {
        if (n > cards.size() || n < 0) {
            throw new IllegalArgumentException("Feil index!");
        }
        return cards.get(n);
    }
    
    /***
     * deal(CardHand, int n) - flytter n kort fra kortstokken
     * (CardDeck-objektet) til korthånda (CardHand-objektet, som er første
     * argument), ved å ta ett og ett kort med høyeste gyldige nr., fjerne det
     * fra CardDeck-objektet og legge det til CardHand-objektet
     */
    public void deal(CardHand ch, int handsize) {
        System.out.println("start: " + this.toString());
        if (handsize > cards.size()) {
            throw new IllegalArgumentException("feil index!");
        } else {
            for (int i = 0; i < handsize; i++) {
                ch.addCard(cards.remove(cards.size()-1));
            }
            System.out.println("deal:add size: " + handsize + " to cardhand:"
                    + ch.toString());
            System.out.println("remove size: " + handsize + " left: "
                    + this.toString());
        }
    }
    
    /***
     * shufflePerfectly() - stokker kortstokken ved å dele den i to like store
     * deler og flette de to delene perfekt, slik at kortet på toppen forblir på
     * toppen og kortet på bunnen forblir på bunnen
     */
    public void shufflePerfectly() {
        int hs=cards.size()/2;
        for (int i = 0; i < hs; i++) {
            Card card = cards.remove(hs + i);
            cards.add(i * 2 + 1, card);
        }
    }
    
    public String toString() {
        String s = "";
        for (Card c : cards) {
            s += c + ", ";
        }
        return s;
    }
}
