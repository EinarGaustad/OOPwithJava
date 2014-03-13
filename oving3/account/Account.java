package oving3.account;

public class Account {
	private double belopet;
	private double rentefoten;
	
	public Account(double belopet, double rentefoten){
		if (ikkeNegativeVerdi(belopet))
			this.belopet	= belopet;
		if (ikkeNegativeVerdi(rentefoten))
			this.rentefoten	= rentefoten;
	}
	public double getBalance(){
		return belopet;
	}
	public double getInterestRate(){
		return rentefoten;
	}
	public void setInterestRate(double rentefoten){
		if (ikkeNegativeVerdi(rentefoten))
				this.rentefoten	= rentefoten;
	}
	public void deposit(double nyBelopet){
		if (ikkeNegativeVerdi(nyBelopet))
			belopet+=nyBelopet;
	}
	public void withdraw(double belop){
		if (ikkeNegativeVerdi(belop)){
			if (belopet - belop < 0){
				throw new IllegalStateException("kan ikke withdraw så mye!");
			}
			else
				belopet -= belop;
		}
			
	}
	public String toString(){
		return "belopet: "+belopet+";  rent: "+rentefoten;
	}
	public boolean ikkeNegativeVerdi(double verdi){
		if (verdi < 0){
			throw new IllegalArgumentException("verdiene kan ikke være negative");
		}
		return true;
	}
}
/*
Forklar hvorfor metodene over kan sies å være en komplett innkapsling av tilstanden?
Er denne klassen data-orientert eller tjeneste-orientert? Begrunn svaret!
 */

