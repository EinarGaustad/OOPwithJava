package oving6.named;
/***
 * Person2 skal ha ett felt for fullt navn (fullName) og 
 * en konstruktør som tar inn det fulle navnet. 
 * Begge skal imidlertid implementere samme logikk, 
 * dvs. ha get- og set-metoder for fornavn, etternavn og fullt navn
 * @author junjun
 *
 */
public class Person2 extends Person1 implements Named{
	
	public Person2(String fullnavn){
		super(fullnavn);
	}
	public Person2(String fornavn, String etternavn) {
		super(fornavn, etternavn);
	}
}
