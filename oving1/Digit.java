package oving1;

/***
 * 
 * @author GuoJunjun Oppgaven handler om en Digit-klasse, som representerer ett
 *         siffer i et gitt tallsystem. Tilstanden i Digit-objekter er todelt:
 * 
 *         en int som angir tallsystemet, f.eks. 10 for titallssystemet, som
 *         oppgis i konstruktøren en int-verdi, som representerer siffer-verdien
 *         i det angitt tallsystem og må være fra og med 0 til (men ikke med)
 *         tallsystem-verdien Konstruktøren tar inn en int, som initialisere
 *         tallsystem-verdien, mens siffer-verdien settes til 0.
 * 
 *         Digit-tilstanden leses og oppdateres med følgende to metoder:
 * 
 *         int getValue() - returnerer siffer-verdien boolean increment() - øker
 *         siffer-verdien med én. Dersom den da når tallsystem-verdien, så
 *         (re)settes den til 0 og metoden returnerer true, ellers returnerer
 *         den false. Del 1 - tilstandsdiagram Tegn et objekttilstandsdiagram
 *         for en tenkt bruk av Digit-klassen. Sekvensen av kall må illustrere
 *         hele oppførselen til increment()-metoden.
 * 
 *         Del 2 - Java-kode Skriv Java-kode for Digit-klassen med oppførsel som
 *         er beskrevet over. Lag også en toString()-metode som returnerer
 *         siffer-verdien som en String, hvor sifrene 0-9 etterfølges av A-Z.
 *         F.eks. skal siffer-verdien 10 i sekstentallssystemet gi "A" som
 *         returverdi.
 * 
 *         Lag et hovedprogram, slik at du kan sjekke at oppførselen stemmer med
 *         tilstandsdiagrammet (bruk samme sekvens av kall).
 */
public class Digit {
	
	int	tallsystemet;
	int	verdi	= 0;
	
	public Digit(int tallsystemet) {
		this.tallsystemet = tallsystemet;
	}
	
	public int getValue() {
		return verdi;
	}
	
	public boolean increment() {
		verdi += 1;
		if (verdi == tallsystemet) {
			verdi = 0;
			return true;
		} else
			return false;
	}
	
	public String toString() {
		if (verdi < 10)
			return "" + verdi;
		else
			return "" + (char) (verdi + 55);
	}
}