package oving1.account;

public class Account {
	double balance;
	double interestRate;
	
	public Account(double balance, double interestRate){
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public Account() {
		//balance = 0;
		//interestRate = 0;
	}

	public void deposit(double deposit) {
		if (deposit >= 0) { // || deposit == 0
			balance +=deposit;
		}
		//else
			//System.out.println("deposit kan ikke være negativ!");
			
	}
	
	// trenger ikke:
//	public void addInterest(double interestRate){
//		if (interestRate > 0 || interestRate == 0) {
//			this.interestRate +=interestRate;
//		}
//		else
//			System.out.println("interestRate kan ikke være negativ!");
//	}
	
	
	public void addInterest() {
		balance += balance*(interestRate/100.0);
	}
	//alle java har toString
	public String toString(){
		return "Balance: "+balance+"  interest rate: "+interestRate;
	}

}
