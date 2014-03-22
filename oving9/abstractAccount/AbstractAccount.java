/**
 * An abstract <method> has no implementation: forces the implementors of
 * subclasses to specify concrete implementations
 * 
 * A class for which you cannot create objects is called an abstract class.
 * 
 * A class for which you can create objects is sometimes called a concrete
 * class.
 * 
 * If a class extends an abstract class without providing an implementation of
 * all abstract meth- ods, it too is abstract.
 */
package oving9.abstractAccount;

/**
 * 
 * @author GuoJunjun
 * 
 *         Denne oppgaven handler om å lage en felles abstrakt superklasse
 *         AbstractAccount for CreditAccount, DebitAccount- og
 *         SavingsAccount-klassene. Denne oppgaven er en annen variant
 *         SavingsAccount-oppgaven, med fokus på bruk av abstrakte klasser og
 *         arv.
 * 
 *         Abstrakt klasse AbstractAccount En bank består av mange ulike type
 *         kontoer: sparekontoer, brukskontoer, depositumskontoer, støttekontoer
 *         etc. Felles for alle kontoer er den abstrakt AbstractAccount-klassen,
 *         som er en utvidelse grensesnittet fra SavingsAccount-oppgaven.
 */
public abstract class AbstractAccount {
	
    protected double belop;
	/**
	 * void deposit(double) - øker kontobalansen med innskutt beløp. Merk at det
	 * innskutte beløpet må være positivt. Ved ulovlig innskudd skal en
	 * IllegalArgumentException utløses.
	 */
	public AbstractAccount() {
		belop = 0;
	}
	void deposit(double belop) {
		if (belop <= 0) {
			throw new IllegalArgumentException(
					"deposit amount must be positive");
		}
		this.belop += belop;
	}
	
	/**
	 * 
	 * @param belop
	 *            Metoden kaller internalWithdraw(uttaksbeløp), som
	 *            implementeres i hver subklasse. Hvis uttaksbeløpet er negativt
	 *            skal metoden utløse en IllegalArgumentException.
	 */
	void withdraw(double belop) {
		internalWithdraw(belop);
		// if (belop > this.belop) {
		// throw new IllegalArgumentException("Not enought amount to withdraw");
		// } else {
		// this.belop = belop;
		// }
	}
	
	/**
	 * 
	 * @param belop
	 *            minsker kontobalansen med beløpet som blir tatt ut. Merk at
	 *            reglene for uttak er ulik for klassene som implementerer
	 *            AbstractAccount, og må derfor implementeres i hver klasse.
	 *            Hvis det ikke er mulig å ta ut det angitte beløpet skal
	 *            metoden utløse en IllegalStateException.
	 */
	abstract void internalWithdraw(double belop);
	
	/**
	 * returnerer kontobalansen
	 */
	double getBalance() {
		return this.belop;
	}
}
