package oving3.person;

import java.util.Date;

/***
 * 
 * @author GuoJunjun Oppgaven handler om en Person-klasse, som håndterer
 *         informasjon om en person (navn, e-post, fødselsdato og kjønn) og
 *         implementerer innkapslingsmetoder med validering. Et Person-objekt
 *         inneholder navn (både fornavn og etternavn), e-post, fødselsdag og
 *         kjønn:
 * 
 *         Navnet inneholder både fornavn og etternavn (og ingen mellomnavn),
 *         som begge må være på minst to bokstaver langt, navnene må være skilt
 *         med ett mellomrom og kun inneholde bokstaver.
 * 
 *         E-post-adressen (hvis den ikke er null) må være på formen
 *         fornavn.etternavn@domene.landskode, f.eks.
 *         hallvard.trætteberg@ntnu.no (en liste over landskoder finner du på
 *         http://countrycode.org/).
 * 
 *         Fødselsdagen skal være et dato-objekt (java.util.Date) og kan ikke
 *         være frem i tid. En persons kjønn skal kunne returneres som 'M', 'F'
 *         eller '\0' (null-tegnet). Person-klassen har tilgangsmetoder for å
 *         hente og sette tilstandene. Dersom et argument er ugyldig i seg selv,
 *         så skal unntaket IllegalArgumentException utløses. Dersom et argument
 *         ikke stemmer med andre verdier i objektet så skal unntaket
 *         IllegalStateException utløses.
 * 
 *         setName(String) - oppdaterer navnet (fornavn og etternavn med
 *         mellomrom mellom), dersom det er gyldig i henhold til kravene over.
 *         Det er greit om navnet som settes, ikke stemmer med e-post-adressen.
 *         setEmail(String) - oppdaterer e-post-adressen, etter å ha sjekket at
 *         den stemmer med navnet. setBirthday(Date) - oppdaterer fødselsdatoen
 *         setGender(char) - oppdaterer kjønnet I tillegg til disse såkalte
 *         setter-metodene, så må Person-klassen ha tilsvarende getter-metoder.
 * 
 *         Del 1 – Java-kode Implementer Person-klassen med stram innkapsling.
 *         Eventuelle hjelpemetoder for validering bør også ha stram
 *         innkapsling.
 * 
 *         JExercise-testkode for denne oppgaven finner du her:
 *         encapsulation/PersonTest.java
 * 
 *         Del 2 - Spørsmål om innkapsling Foreslå en alternativ innkapsling av
 *         navnet. Hint: del opp.
 * 
 *         Foreslå to alternative strategier for å kapsle inn tilstand som er
 *         koblet slik navn og e-post er. Hint: 1) samtidig og 2) dekoble.
 * 
 *         Del 3 – Ekstraoppgave: Personnummer Utvid klassen med en persons
 *         personnummer. Personnummeret kan ikke settes før kjønn og fødselsdag
 *         er satt.
 * 
 *         Et personnummer består grovt sett av fødselsdatoen, et (vilkårlig)
 *         løpenummer og to kontrollsifre. Kontrollsifrene gjør det enklere å
 *         sjekke om et personnummer er ekte. Mer spesifikt er reglene for
 *         personnummer som følger:
 * 
 *         Et personnummer består av 11 siffer, med følgende struktur:
 *         D1D2M1M2Y1Y2N1N2N3K1K2 (fargen illustrerer siffergruppene). De seks
 *         første sifrene, D1D2M1M2Y1Y2, tilsvarer fødselsdatoens dag (1-31),
 *         måned (1-12) og år (0-99). De tre neste sifrene, N1N2N3, kan antas å
 *         være vilkårlige, men N3 må være partall for kvinner og oddetall for
 *         menn. De to siste sifrene, K1K2, er kontrollsifre, som hver for seg
 *         beregnes ut fra de foregående sifrene. Formelen for dem begge er 11 –
 *         (VS % 11), hvor VS (veid sum) for K1 er D1*F1 + D2*F2 + … + N2*F8 +
 *         N3*F9 og VS for K2 er D1*G1 + D2*G2 + … + N3*G9 + K1*G10. F’ene og
 *         G’ene er oppgitt i tabellen under. Dersom formelen gir tallet 11 så
 *         skal verdien 0 brukes isteden. Om både K1 og K2 stemmer med
 *         kontrollsifferne generert basert på formlene over, så er
 *         kontrollsifferne i personnummeret gyldig
 * 
 *         1 2 3 4 5 6 7 8 9 10 F 3 7 6 1 8 9 4 5 2 G 5 4 3 2 7 6 5 4 3 2
 *         Implementer kode for å sette (med metoden setSSN(String) og validere
 *         et gyldig personnummer.
 */
public class Person {
	
	private String	fornavn;
	private String	etternavn;
	private String	epost;
	private char	kjonn;
	private Date	fodselsdag;
	
	// public Person(){
	// }
	/***
	 * Navnet inneholder både fornavn og etternavn (og ingen mellomnavn), som
	 * begge må være på minst to bokstaver langt, navnene må være skilt med ett
	 * mellomrom og kun inneholde bokstaver.
	 * 
	 * @param navnet
	 */
	public void setName(String navnet) {
		String[] splitNavnet = navnet.split(" ");
		//
		
		if (splitNavnet.length != 2 || !isValidName(splitNavnet[0])
				|| !isValidName(splitNavnet[1])) {
			throw new IllegalArgumentException("Navnet inneholder"
					+ " både fornavn og etternavn "
					+ "(og ingen mellomnavn), som begge må være "
					+ "på minst to bokstaver langt, "
					+ "navnene må være skilt med ett mellomrom "
					+ "og kun inneholde bokstaver");
		}
		fornavn = splitNavnet[0];
		etternavn = splitNavnet[1];
	}
	
	public void setEmail(String epost) {
		if (!isValidEpost(epost)) {
			throw new IllegalArgumentException("E-post-adressen "
					+ "(hvis den ikke er null) må være på formen fornavn."
					+ "etternavn@domene.landskode, f.eks. "
					+ "hallvard.trætteberg@ntnu.no");
		}
		this.epost = epost;
	}
	
	public void setBirthday(Date fodselsdag) {
		if (fodselsdag.after(new Date())) {
			throw new IllegalArgumentException(
					"Fødselsdagen skal være et "
							+ "dato-objekt (java.util.Date) og kan ikke være frem i tid");
		}
		this.fodselsdag = fodselsdag;
	}
	
	public void setGender(char kjonn) {
		if (kjonn == 'M' || kjonn == 'F' || kjonn == '\0') {
			this.kjonn = kjonn;
		} else {
			throw new IllegalArgumentException(
					"En persons kjønn skal kunne returneres "
							+ "som 'M', 'F' eller '\0' (null-tegnet).");
		}
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public String getName() {
		// return getFornavn()+" "+getEtternavn();
		return fornavn + " " + etternavn;
	}
	
	public String getEmail() {
		if (epost == null){
			this.epost = getFornavn()+"."+getEtternavn()+"@ntnu.no";
		}
		return epost;
	}
	
	public char getGender() {
		return kjonn;
	}
	
	public Date getBirthday() {
		return fodselsdag;
	}
	
	public boolean isValidName(String navnet) {
		String bokstaver = "abcdefghijklmnopqrstuvwxyzæøå";
		if (navnet.length() < 2) {
			return false;
		}
		
		for (int i = 0; i < navnet.length(); i++) {
			if (!bokstaver.contains((navnet.charAt(i) + "").toLowerCase())) {
				return false;
			}
			// int charTilTall = (int) navnet.charAt(i);
			// if (charTilTall >= 65 & charTilTall <= 90) {
			// return true;
			// } else if (charTilTall >= 97 & charTilTall <= 122) {
			// return true;
			// }
		}
		return true;
	}
	
	public boolean isValidEpost(String epost) {
		if (epost.length() < 8) {
			return false;
		}
		String[] email = epost.split("@");
		String[] navn = email[0].split(".");
		if (email.length != 2) {
			return false;
		}
		if (!navn[0].equalsIgnoreCase(fornavn)
				|| !navn[1].equalsIgnoreCase(etternavn)) {
			return false;
		}
		String[] adressen = email[1].split(".");
		if (!isValidName(adressen[0]) || !isValidName(adressen[1])) {
			return false;
		}
		return true;
	}
}
