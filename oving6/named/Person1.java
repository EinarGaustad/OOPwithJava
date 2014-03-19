package oving6.named;

/***
 * Person1-klassen skal ha felter for for- og etternavn (altså givenName og
 * familyName) og en konstruktør som tar inn to tilsvarende argumenter.
 * 
 * @author junjun
 * 
 */
public class Person1 implements Named {
	
	private String	fornavn;
	private String	etternavn;
	
	public Person1(String fullnavn) {
		this.setFullName(fullnavn);
	}
	
	public Person1(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}
	
	public void setGivenName(String fornavn) {
		this.fornavn = fornavn;
	}
	
	@Override
	public String getGivenName() {
		return fornavn;
	}
	
	@Override
	public void setFamilyName(String etternavn) {
		this.etternavn = etternavn;
	}
	
	@Override
	public String getFamilyName() {
		return etternavn;
	}
	
	@Override
	public void setFullName(String fullname) {
		this.fornavn = fullname.split(" ")[0];
		this.etternavn = fullname.split(" ")[1];
	}
	
	@Override
	public String getFullName() {
		return fornavn + " " + etternavn;
	}
}
