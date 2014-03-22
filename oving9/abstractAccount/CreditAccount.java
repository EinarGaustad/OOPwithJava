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
    
    private double credit;
    
    CreditAccount(double credit) {
        if (credit < 0) {
            throw new IllegalArgumentException(
                    "credit must always greater or equal to 0");
        } else {
            this.credit = credit;
        }
    }
    
    void setCreditLine(double credit) {
        if (credit < 0) {
            throw new IllegalArgumentException("Can not set negativ credit");
        } else if (credit + belop < 0) {
            throw new IllegalStateException(
                    "New credit must at least cover negativ amount");
        } else {
            
            this.credit = credit;
        }
    }
    
    double getCreditLine() {
        return this.credit;
    }

    @Override
    void internalWithdraw(double belop) {
        if (belop > this.belop + this.credit) {
            throw new IllegalStateException("Not enought amount to withdraw");
        } else if (belop <= 0) {
            throw new IllegalArgumentException(
                    "Can only withdraw positive amount");
        } else {
            this.belop -= belop;
            // if (this.belop < 0) {
            // this.credit -= belop;
            // this.belop = 0;
            // }
        }
    }

}
