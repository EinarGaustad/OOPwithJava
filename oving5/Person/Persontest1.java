package oving5.Person;

public class Persontest1 {
	public static void main(String[] args) {
		Person kari		= new Person("Kari",'F');
		Person ole		= new Person("Ole", 'M');
		
		Person mari		= new Person("Mari",'F');
		Person hans		= new Person("Hans",'M');
		Person tor		= new Person("Tor",'M');
		Person jan		= new Person("Jan",'F');
		Person jonas	= new Person("Jonas",'M');
		
		Person johannes	= new Person("Johanne",'M');
		Person li		= new Person("Li",'F');
		Person matin	= new Person("Matin",'M');
		Person froya	= new Person("Froya",'F');
		Person simen	= new Person("Simen",'M');
		
		mari.setFather(ole);
		kari.addChild(mari);
		ole.addChild(johannes);
		johannes.setMother(kari);
		johannes.addChild(matin);
		//System.out.println(johannes.toString());
		
		li.addChild(matin);
		simen.setFather(matin);
		simen.setMother(froya);
		
		tor.setFather(hans);
		tor.setMother(mari);
		hans.addChild(jan);
		mari.addChild(jan);
		
		jonas.setMother(mari);
		jonas.setFather(hans);
		
		mari.removeChild(tor);
		
		System.out.println(kari.toString());
		System.out.println(ole.toString());
		System.out.println(mari.toString());
		System.out.println(johannes.toString());
		System.out.println(hans.toString());
		System.out.println(li.toString());
		System.out.println(tor.toString());
		System.out.println(jan.toString());
		
		System.out.println(jonas.toString());
		System.out.println(matin.toString());
		System.out.println(froya.toString());
		System.out.println(simen.toString());
		
		System.out.println(kari.getName());
		System.out.println(ole.getName());
		System.out.println(mari.getName());
		System.out.println(johannes.getName());
		
		System.out.println(mari.getChild(1).getName());
		System.out.println(hans.getChild(2).getName());
		System.out.println(hans.getChild(3).getName());
		System.out.println(johannes.getChild(1).getName());

	}
}	
	
