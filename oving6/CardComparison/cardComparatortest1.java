package oving6.CardComparison;

public class cardComparatortest1 {
	public static void main(String[] args) {
		CardComparator(false, 'd');
		
		
	}
	public static void CardComparator(boolean b, char c){
		String color = "SHDC";
		String nycolor;
		
		c = Character.toUpperCase(c);
		nycolor = color.replaceAll(""+c, "");
		if (b){
			nycolor = c +nycolor;
		}
		else{
			nycolor = nycolor +c;
		}
		System.out.println(nycolor);
	}
}
