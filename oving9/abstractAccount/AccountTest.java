package oving9.abstractAccount;


public class AccountTest {
    
    public static void main(String[] args) {
        AbstractAccount a = new DebitAccount();
        DebitAccount b = new DebitAccount();
        System.out.println(a.belop + "\n" + b.belop);
        a.deposit(20000.0);
        b.deposit(20000);
        System.out.println(a.belop + "\n" + b.belop);
        a.withdraw(500);
        b.withdraw(5000);
        System.out.println(a.belop + "\n" + b.belop);
        try {
            a.withdraw(-500);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            b.withdraw(-10000);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(a.belop + "\n" + b.belop);
        try {
            a.withdraw(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            b.withdraw(-10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(a.belop + "\n" + b.belop);

        try {
            a.withdraw(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            b.withdraw(20000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(a.belop + "\n" + b.belop);

    }
}
