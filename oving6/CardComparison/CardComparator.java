package oving6.CardComparison;

import java.util.Comparator;
public class CardComparator implements Comparator<Card>{
	
	private String color = "CDHS";//"SHDC";
	//private String suitOrder = "CDHS";
	private String nycolor;
	//private char trumph;
	
	public CardComparator(boolean b, char c){
		//trumph = c;
		c = Character.toUpperCase(c);
		if (!color.contains(""+c)){
			nycolor = color;
		}
		else{
			nycolor = color.replaceAll(""+c, "");
			if (b){
				nycolor = c +nycolor;
			}
			else{
				nycolor = nycolor +c;
			}
		}
	}

//	public int compare(Card card1, Card card2) {
//		
//		int suit1 = suitOrder.indexOf(card1.getSuit());
//		int suit2 = suitOrder.indexOf(card2.getSuit());
//		if (card1.getSuit()==trumph){
//			suit1 = suitOrder.length();
//		}
//		if (card2.getSuit()==trumph){
//			suit2 = suitOrder.length();
//		}
//		int diff = suit2 - suit1;
//		if (diff == 0){
//			int face1 = card1.getFace();
//			int face2 = card2.getFace();
//			diff = face1 - face2;
//			if (aceIsHighest){
//				if ( face1 == 1){
//					face1 = 14;
//				}
//				if (face2 ==1){
//					face2 = 14;
//				}
//			}
//		}
//		return diff;
//		
//	}
	public int compare(Card c1, Card c2) {
		
		if (nycolor.indexOf(""+c1.getSuit()) > (nycolor.indexOf(""+c2.getSuit()))){
			return 1;
		}
		if (nycolor.indexOf(""+c1.getSuit()) < (nycolor.indexOf(""+c2.getSuit()))){
			return -1;
		}
		else {
			int f1 = c1.getFace();
			int f2 = c2.getFace();
			if (f1 == 13 || f2 == 13){
				if (f1 == 1){
					f1 = 14;
				}
				if (f2 == 1){
					f2 = 14;
				}
			}
				if ( f1 > f2){
					return 1;
				}
				if ( f1 < f2){
					return -1;	
				}
			return 0;
		}
	}

}
