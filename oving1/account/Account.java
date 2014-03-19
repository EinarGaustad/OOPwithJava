package oving1.account;

/***
 * 
 * @author GuoJunjun Oppgaven handler om en Account-klasse, som håndterer data i
 *         en konto. Tilstanden i Account-objekter er som følger:
 * 
 *         balance - et desimaltall som angir beløpet som er på kontoen
 *         interestRate - et desimaltall som angir rentefot som prosentpoeng.
 *         Account-klassen har to metoder, deposit og addInterest, med følgende
 *         oppførsel:
 * 
 *         deposit(double) - øker konto-beløpet med den angitte argument-verdien
 *         (et desimaltall), men kun dersom det er positivt addInterest() -
 *         beregner renta og legger det til konto-beløpet Del 1 -
 *         tilstandsdiagram Tegn et objekttilstandsdiagram for en tenkt bruk av
 *         Account-klassen. Velg selv en passende start-tilstand for
 *         Account-objektet og sekvens av kall.
 * 
 *         Del 2 - Java-kode Skriv Java-kode for Account-klassen med oppførsel
 *         som er beskrevet over.
 * 
 *         Lag en passende toString()-metode og et hovedprogram, slik at du kan
 *         sjekke at oppførselen stemmer med tilstandsdiagrammet (bruk samme
 *         start-tilstand og sekvens av kall).
 */
public class Account {
	
	double	balance;
	double	interestRate;
	
	public Account(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public Account() {
		// balance = 0;
		// interestRate = 0;
	}
	
	public void deposit(double deposit) {
		if (deposit >= 0) { // || deposit == 0
			balance += deposit;
		}
		// else
		// System.out.println("deposit kan ikke være negativ!");
		
	}
	
	// trenger ikke:
	// public void addInterest(double interestRate){
	// if (interestRate > 0 || interestRate == 0) {
	// this.interestRate +=interestRate;
	// }
	// else
	// System.out.println("interestRate kan ikke være negativ!");
	// }
	
	public void addInterest() {
		balance += balance * (interestRate / 100.0);
	}
	
	// alle java har toString
	public String toString() {
		return "Balance: " + balance + "  interest rate: " + interestRate;
	}
	
}
