package oving1.account;

public class accouttest1 {
	public static void main (String[] ags){
		//System.out.println(new Account().toString());
		Account tabell [] = new Account [5];
		tabell [0]= new Account (100.0,2.0);
		tabell [1]= new Account (500.0,2.1);
		tabell [2]= new Account (1500.0,2.2);
		tabell [3]= new Account (2000.0,2.3);
		tabell [4]= new Account (2500.0,2.4);
		for (int i=0; i<5;i++){
			System.out.println("start: ");
			System.out.println("     "+tabell[i]);//);.toString());auto call toString
			
			System.out.println("deopsit+500");
			tabell[i].deposit(500.0);
			System.out.println("     "+tabell[i].toString());
			
			System.out.println("interest+0.5");
			//tabell[i].addInterest(0.5);
			System.out.println("     "+tabell[i].toString());
			
			System.out.println("deopsit-1500");
			tabell[i].deposit(-1500.0);
			System.out.println("     "+tabell[i].toString());
			
			System.out.println("interest-2.5");
			//tabell[i].addInterest(-2.5);
			System.out.println("     "+tabell[i].toString()+"\n");
		}
	}
}
