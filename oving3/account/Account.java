package oving3.account;

/***
 * 
 * @author GuoJunjun Oppgaven er en innkapslet og litt utvidet variant av
 *         Account-oppgaven under temaet Tilstand og oppførsel, og stiller bl.a.
 *         større krav til validering. Et Account-objekt inneholder data om
 *         beløpet som står på kontoen og rentefoten (prosentpoeng).
 * 
 *         Begge verdiene skal oppgis og settes når objektet opprettes og ingen
 *         av verdiene kan være negative.
 * 
 *         Account-klassen har metoder for å sette inn og ta ut beløp, og legge
 *         til påløpte renter, i tillegg til en konstruktør for å initialisere
 *         en ny konto. Alle disse skal utløse unntak av typen
 *         IllegalArgumentException, dersom et argument ikke tilfredstiller
 *         kravene som angis.
 * 
 *         Account(double, double) - Konstruktøren skal ta inn startbeløpet og
 *         rentefoten (prosentpoeng). Ingen av disse kan være negative. double
 *         getBalance() - Returnerer beløpet som står på kontoen. double
 *         getInterestRate() - Returnerer renten på kontoen. void
 *         setInterestRate(double) - Denne metoden tar inn en ikke-negativ verdi
 *         og setter renten til denne verdien. void deposit(double) - Denne
 *         metoden tar inn et ikke-negativt beløp og øker konto-beløpet
 *         tilsvarende. void withdraw(double) - Denne metoden tar inn et
 *         ikke-negativt beløp og minsker konto-beløpet tilsvarende. Dersom det
 *         nye konto-beløpet er negativt, så skal tilstanden ikke endre, og det
 *         skal utløses et unntak av typen IllegalStateException. Del 1 –
 *         Innkapsling og validering: teori Ta utgangspunkt i koden fra
 *         Account-klassen og besvar følgende spørsmål:
 * 
 *         Forklar hvorfor metodene over kan sies å være en komplett innkapsling
 *         av tilstanden? Er denne klassen data-orientert eller
 *         tjeneste-orientert? Begrunn svaret! Del 2 - Java-kode Implementer
 *         endringene fra Account-klassen i den nye Account-klassen med
 *         oppførsel som er beskrevet over.
 */
public class Account {
	
	private double	belopet;
	private double	rentefoten;
	
	public Account(double belopet, double rentefoten) {
		if (ikkeNegativeVerdi(belopet))
			this.belopet = belopet;
		if (ikkeNegativeVerdi(rentefoten))
			this.rentefoten = rentefoten;
	}
	
	public double getBalance() {
		return belopet;
	}
	
	public double getInterestRate() {
		return rentefoten;
	}
	
	public void setInterestRate(double rentefoten) {
		if (ikkeNegativeVerdi(rentefoten))
			this.rentefoten = rentefoten;
	}
	
	public void deposit(double nyBelopet) {
		if (ikkeNegativeVerdi(nyBelopet))
			belopet += nyBelopet;
	}
	
	public void withdraw(double belop) {
		if (ikkeNegativeVerdi(belop)) {
			if (belopet - belop < 0) {
				throw new IllegalStateException("kan ikke withdraw så mye!");
			} else
				belopet -= belop;
		}
		
	}
	
	public String toString() {
		return "belopet: " + belopet + ";  rent: " + rentefoten;
	}
	
	public boolean ikkeNegativeVerdi(double verdi) {
		if (verdi < 0) {
			throw new IllegalArgumentException(
					"verdiene kan ikke være negative");
		}
		return true;
	}
}
/*
 * Forklar hvorfor metodene over kan sies å være en komplett innkapsling av
 * tilstanden? Er denne klassen data-orientert eller tjeneste-orientert? Begrunn
 * svaret!
 */

