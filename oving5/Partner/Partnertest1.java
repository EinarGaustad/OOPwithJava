package oving5.Partner;


public class Partnertest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partner kari	= new Partner("Kari");
		Partner ole		= new Partner("Ole");
		Partner mari	= new Partner("Mari");
		Partner johanne	= new Partner("Johanne");
		
		System.out.println(kari.toString());
		System.out.println(ole.toString());
		System.out.println(mari.toString());
		System.out.println(johanne.toString());
		
		System.out.println(kari.getName());
		System.out.println(ole.getName());
		System.out.println(mari.getName());
		System.out.println(johanne.getName());
		
		System.out.println(kari.getPartner());
		System.out.println(ole.getPartner());
		System.out.println(mari.getPartner());
		System.out.println(johanne.getPartner());
		System.out.println(" --------- ");
		
		kari.setPartner(ole);
		//ole.setPartner(mari);
		mari.setPartner(johanne);
		//johanne.setPartner(kari);
		
		System.out.println(kari.toString());
		System.out.println(ole.toString());
		System.out.println(mari.toString());
		System.out.println(johanne.toString());
		
		System.out.println(kari.getName());
		System.out.println(ole.getName());
		System.out.println(mari.getName());
		System.out.println(johanne.getName());
		
		System.out.println(kari.getPartner());
		System.out.println(ole.getPartner());
		System.out.println(mari.getPartner());
		System.out.println(johanne.getPartner());
	}
}
