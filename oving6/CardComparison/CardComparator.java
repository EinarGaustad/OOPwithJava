package oving6.CardComparison;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    private String SUITS = "CDHS"; ;// "SHDC";
    private String newSuits;
    private boolean ace;
    
    public CardComparator(boolean b, char c) {
        c = Character.toUpperCase(c);
        if (!SUITS.contains("" + c)) {
            newSuits = SUITS;
        } else {
            newSuits = SUITS.replaceAll("" + c, "");
            newSuits = newSuits + c;
        }
        ace = b;
    }
    
    public int compare(oving5.Card.Card c1, oving5.Card.Card c2) {

        if (newSuits.indexOf("" + c1.getSuit()) > (newSuits.indexOf(""
                + c2.getSuit()))) {
            return 1;
        }
        if (newSuits.indexOf("" + c1.getSuit()) < (newSuits.indexOf(""
                + c2.getSuit()))) {
            return -1;
        } else {
            
            int f1 = c1.getFace();
            int f2 = c2.getFace();
            if (ace) {
                if (f1 == 1) {
                    f1 = 14;
                }
                if (f2 == 1) {
                    f2 = 14;
                }
            }
            if (f1 > f2) {
                return 1;
            }
            if (f1 < f2) {
                return -1;
            }
            return 0;
        }
    }
    
    public int compare(Card c1, Card c2) {

        if (newSuits.indexOf("" + c1.getSuit()) > (newSuits.indexOf(""
                + c2.getSuit()))) {
            return 1;
        }
        if (newSuits.indexOf("" + c1.getSuit()) < (newSuits.indexOf(""
                + c2.getSuit()))) {
            return -1;
        } else {
            
            int f1 = c1.getFace();
            int f2 = c2.getFace();
            if (ace) {
                if (f1 == 1) {
                    f1 = 14;
                }
                if (f2 == 1) {
                    f2 = 14;
                }
            }
            if (f1 > f2) {
                return 1;
            }
            if (f1 < f2) {
                return -1;
            }
            return 0;
        }
    }
}
