package oving6.CardComparison;


import java.util.ArrayList;

import oving6.cardcontainer.CardContainerIterator;
import oving6.cardcontainer.CardDeck;

public class cardComparatortest1 {
	public static void main(String[] args) {
        Card cc1 = new Card('C', 1);
        Card cc2 = new Card('D', 1);
        if ("DHCS".indexOf("" + cc1.getSuit()) > ("DHCS".indexOf(""
                + cc2.getSuit()))) {
            System.out.println(cc1.toString() + " compare " + cc2.toString());

        }

        ArrayList<oving5.Card.Card> list = new ArrayList<oving5.Card.Card>();

        CardDeck card = new CardDeck(13);
        CardContainerIterator it = new CardContainerIterator(card);
        String s1 = " ";
        while (it.hasNext()) {
            s1 += it.next() + ", ";
        }
        System.out.println(s1);
        CardComparator cc = new CardComparator(false, 'H');
        for (int i = 0; i < card.getCardCount(); i++) {
            list.add(card.getCard(i));
        }
        // System.out.println("size: " + card.getCardCount() + " " +
        // list.size());
        for (int i = 0; i < card.getCardCount(); i++) {
            oving5.Card.Card c1=list.get(i);
            for (int j = i+1; j < card.getCardCount(); j++) {
                // System.out.println("out loop i: " + i + " inne loop j: " +
                // j);
                oving5.Card.Card c2 = list.get(j);
                if (cc.compare(c1, c2) == 1) {
                    // System.out.println("c1 =: " + c1.toString()
                    // + "  c1=  c2 = "
                    // + c2.toString());
                    c1 = c2;

                }
            }
            // System.out.println("add bigget to list" + c1);
            list.add(i, list.remove(list.indexOf(c1)));
        }
        String s2 = " ";
        for (oving5.Card.Card cit : list) {
            s2 += cit.toString() + ", ";
        }
        System.out.println(s2);
        //
        
        ArrayList<oving5.Card.Card> list2 = new ArrayList<oving5.Card.Card>();
        CardComparator ccc = new CardComparator(true, 'H');
        for (int i = 0; i < card.getCardCount(); i++) {
            list2.add(card.getCard(i));
        }
        // System.out.println("size: " + card.getCardCount() + " " +
        // list.size());
        for (int i = 0; i < card.getCardCount(); i++) {
            oving5.Card.Card c1 = list2.get(i);
            for (int j = i + 1; j < card.getCardCount(); j++) {
                // System.out.println("out loop i: " + i + " inne loop j: " +
                // j);
                oving5.Card.Card c2 = list2.get(j);
                if (ccc.compare(c1, c2) == 1) {
                    // System.out.println("c1 =: " + c1.toString()
                    // + "  c1=  c2 = "
                    // + c2.toString());
                    c1 = c2;
                    
                }
            }
            // System.out.println("add bigget to list" + c1);
            list2.add(i, list2.remove(list2.indexOf(c1)));
        }
        String ss2 = " ";
        for (oving5.Card.Card cit : list2) {
            ss2 += cit.toString() + ", ";
        }
        System.out.println(ss2);
        // CardComparator cc = new CardComparator(false, 'd');
        // Card c1 = new Card('C', 1);
        // Card c2 = new Card('D', 1);
        // System.out.println(cc.compare(c1, c2));

        // String suits = "SHDC";
        // ArrayList<Card> list = new ArrayList<Card>();
        // for (int i = 0; i < suits.length(); i++) {
        //
        // }

	}
    // public static void CardComparator(boolean b, char c){
    // String color = "SHDC";
    // String nycolor;
    //
    // c = Character.toUpperCase(c);
    // nycolor = color.replaceAll(""+c, "");
    // if (b){
    // nycolor = c +nycolor;
    // }
    // else{
    // nycolor = nycolor +c;
    // }
    // System.out.println(nycolor);
    // }
}
