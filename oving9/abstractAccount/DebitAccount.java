package oving9.abstractAccount;

/**
 * 
 * @author GuoJunjun En debetkonto er den enkleste formen for konto, hvor det
 *         eneste kravet er at saldoen til enhver tid må være større eller lik
 *         0. DebitAccount skal implementere AbstractAccount og sikre at saldoen
 *         aldri blir lavere enn 0.
 */
public class DebitAccount extends AbstractAccount {
    
	@Override
	void internalWithdraw(double belop) {
        if (belop > this.belop) {
            throw new IllegalStateException("Not enought amount to withdraw");
		} else if (belop <= 0) {
            throw new IllegalArgumentException(
					"Can only withdraw positive amount");
		} else {
			this.belop -= belop;
		}
	}
	

	
}
