package oving5.Partner;
//import java.util.ArrayList;
public class Partner {
	private String name;
	private Partner partner;
	//private ArrayList<Partner> partner;
	
	public Partner(String name){
		this.name = name;
		partner = null;//ArrayList<Partner>();
	}
	
	public void setPartner(Partner partnerName){
		//if (partnerName == null){
			//throw new IllegalArgumentException("partner kan ikke være null");
		//}
		Partner p = partner;
		if (this.partner != partnerName){
			this.partner= partnerName;
			//partnerName.partner = this.partner;
		}
		if (partnerName != null && partnerName.partner != this){
			partnerName.partner = this;
		}
		if (partnerName == null && p != null){
			p.partner = null;
		}
		
	}
	
	public String toString(){		
		return	"Name: " + name;
	}
	
	public String getName(){
		if (partner==null){
			return "No partner";
		}
		return this.name;
	}
	
	public Partner getPartner(){
		if (partner == null){
			return null;
		}
		return partner;
	}
	//public void setDivorce(Partner partnerName){
		//if (this.partner ==(partnerName)){
			//this.partner = null;
			//partnerName.setDivorce(this);
		//}
	//}
}
