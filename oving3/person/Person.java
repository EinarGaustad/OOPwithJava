package oving3.person;
import java.util.Date;

public class Person {
	private String fornavn;
	private String etternavn;
	private String epost;
	private char kjonn;
	private Date fodselsdag;
	//public Person(){	
	//}
	/***
	 * Navnet inneholder både fornavn og etternavn 
	 * (og ingen mellomnavn), 
	 * som begge må være på minst to bokstaver langt, 
	 * navnene må være skilt med ett mellomrom og kun 
	 * inneholde bokstaver.
	 * @param navnet
	 */
	public void setName(String navnet){
		String [] splitNavnet = navnet.split(" ");
		//

		if (splitNavnet.length!=2 || ! isValidName(splitNavnet[0]) || ! isValidName(splitNavnet[1])){
			throw new IllegalArgumentException("Navnet inneholder"
					+ " både fornavn og etternavn "
					+ "(og ingen mellomnavn), som begge må være "
					+ "på minst to bokstaver langt, "
					+ "navnene må være skilt med ett mellomrom "
					+ "og kun inneholde bokstaver");
		}
		fornavn		= splitNavnet[0];
		etternavn	= splitNavnet[1];
	}
	public void setEmail(String epost){
		if (! isValidEpost(epost)){
			throw new IllegalArgumentException("E-post-adressen "
					+ "(hvis den ikke er null) må være på formen fornavn."
					+ "etternavn@domene.landskode, f.eks. "
					+ "hallvard.trætteberg@ntnu.no");
		}
		this.epost	= epost;
	}
	public void setBirthday(Date fodselsdag){
		if (fodselsdag.after(new Date())){
			throw new IllegalArgumentException("Fødselsdagen skal være et "
					+ "dato-objekt (java.util.Date) og kan ikke være frem i tid");
		}			
		this.fodselsdag = fodselsdag;
	}
	public void setGender(char kjonn){
		if (kjonn == 'M' || kjonn == 'F' || kjonn == '\0'){
			this.kjonn = kjonn;
		}
		else {
			throw new IllegalArgumentException("En persons kjønn skal kunne returneres "
					+ "som 'M', 'F' eller '\0' (null-tegnet).");
		}
	}
	public String getFornavn(){
		return fornavn;	
	}
	public String getEtternavn(){
		return etternavn;
	}
	public String getName(){
		//return getFornavn()+" "+getEtternavn();
		return fornavn + " " + etternavn;
	}
	public String getEmail(){
		return epost;
	}
	public char getGender(){
		return kjonn;
	}
	public Date getBirthday(){
		return fodselsdag;
	}
	public boolean isValidName(String navnet){
		//String bokstaver = "abcdefghijklmnopqrstuvwxyzæøå";
		if (navnet.length() < 2)
			return false;
		for (int i = 0; i<navnet.length(); i++){
			int charTilTall=(int) navnet.charAt(i);
			if (charTilTall>=65 & charTilTall<=90)
				return true;
			else if (charTilTall>=97 & charTilTall<=122)
				return true;
		}
		return false;
	}
	public boolean isValidEpost(String epost){
		String [] email = epost.split("@");
		String [] navn	= email[0].split(".");
		if (email.length!=2)
				return false;
		if (! navn[0].equalsIgnoreCase(fornavn) || ! navn[1].equalsIgnoreCase(etternavn))
			return false;
		String [] adressen = email[1].split(".");
		if (! isValidName(adressen[0]) || ! isValidName(adressen[1]))
			return false;
		return true;
	}
}
