package oving1;

public class digittest1 {
	public static void main(String[] args){
		Digit tabell [] = new Digit [5];

		for (int i=0; i<5;i++){
			int tall = (int) (Math.random()*35)+2;
			tabell [i] = new Digit(tall);
			System.out.println("	tallsystem: "+tall);
			for (int j=0; j<tall; j++){
				tabell[i].increment();
				System.out.println(tabell[i].toString());
			}
		}
	}
}
