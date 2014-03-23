package oving9.abstractAccount;

/**
 * 
 * @author GuoJunjun En SavingsAccount kan kun ha positiv saldo. I tillegg har
 *         kontoen uttaksbegrensinger. En SavingsAccount har x antall
 *         withdrawals. Dersom man ønsker å ta ut penger etter alle uttak er
 *         brukt opp, skal saldoen belastes med en fee. Både withdrawals og fee
 *         settes i konstruktøren SavingsAccount(int, double).
 */
public class SavingsAccount extends AbstractAccount {
    
    private int    withdrawals;
    private double fee;
    
    SavingsAccount(int withdrawals, double fee) {
        this.withdrawals = withdrawals;
        this.fee = fee;
    }
    
    @Override
    void internalWithdraw(double belop) {
        if (belop >= this.belop) {
            throw new IllegalStateException("Not enought amount to withdraw");
        } else if (belop <= 0) {
            throw new IllegalArgumentException(
                    "Can only withdraw positive amount");
        } else {
            if (withdrawals < 1) {
                if (belop + fee >= this.belop) {
                    throw new IllegalStateException(
                            "Not enought amount to withdraw");
                } else {
                    this.belop -= (belop + fee);
                    withdrawals--;
                }
            } else {
                this.belop -= belop;
                withdrawals--;
            }
        }
    }
}
