package oving3.account;

public class accountTest1 {
	public static void main(String[] args){
		Account account	= new Account(1000, 0.5);
		System.out.println(account.toString());
		account.setInterestRate(1);
		System.out.println(account.toString());

	}
}
