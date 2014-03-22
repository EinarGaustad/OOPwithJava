package oving9.abstractAccount;

/**
 * 
 * @author GuoJunjun En CreditAccount har i tillegg til balance en tilstand for
 *         creditLine, altså tilgjengelig kreditt på kontoen. Denne
 *         kredittlinjen tillater at kontoen kan overtrekkes (at saldoen er
 *         negativ) innenfor kredittlinjen. Klassen må ha tilgangsmetoder
 *         (getters and setters) for creditLine. Merk at kredittlinjen alltid må
 *         være større eller lik 0, hvis ikke skal det utløses en
 *         IllegalArgumentException. Hvis en ny kredittlinje settes og balansen
 *         er negativ, må den nye kredittlinjen dekke den eksisterende balansen.
 *         Ellers skal det utløses en IllegalStateException og ingen endring i
 *         kredittlinjen.
 * 
 *         Konstruktøren CreditAccount(double) skal sette kredittlinjen.
 */
public class CreditAccount extends AbstractAccount {
	
}
