package oving5.Person;
import java.util.ArrayList;
import java.util.Collection;

public class Person {
	private Person mor;//Collection<Person> 	mor;
	private Person far;//Collection<Person> 	far;
	private Collection<Person> barn;//ArrayList<Person> 	barn;
	private String				name;
	private char				gender;
	
	//public Person(String name, char gender, String mor, String far, String barn){

	public Person(String name, char gender){
		this.name 	= name;
		this.gender = gender;
		mor 		=null;//= new ArrayList<Person>();
		far 		=null;// new ArrayList<Person>();
		barn		= new ArrayList<Person>();
	}
	
	public String getName(){
		return name;
	}
	public char getGender(){
		return gender;
	}
	public Person getMother(){
		return mor;
		/*
		if( mor.size() == 0){
			return null;
		}
		return ((ArrayList<Person>) mor).get(0);
		*/
	}
	public Person getFather(){
		//if( far == null){
		//	return null;
		//}
		return far;
	}
	public Person getChild(int n){
		if( barn.size() <= n || barn.size() < 0){
			throw new IllegalArgumentException("feil inndata!!");
		}
		return ((ArrayList<Person>) barn).get(n);
	}
	public int getChildCount(){
		return barn.size();
	}
	public void addChild(Person child){
		if (!barn.contains(child)){
			barn.add(child);
		}
		if (this.gender == 'M'){
			if (child.getFather() == null){
				child.setFather(this);
			}
		}
		if (this.gender == 'F'){
			if (child.getMother() == null){
				child.setMother(this);
			}
		}
	}
	public void removeChild(Person child){
		if (barn.contains(child)){
			barn.remove(child);
		}
		if (this.gender == 'M'){
			if (child.getFather() != null){
				child.far =null;
			}
		}
		if (this.gender == 'F'){
			if (child.mor == (this)){
				child.mor = null;
			}
		}
	}
	public void setMother(Person mother){
		//if( mother != null && (mother == this || mother  == this.mor || (mother.gender != this.gender)))
		if (mother.getGender()!='F' || this==mother){
			throw new IllegalArgumentException("mor må være F");
		}
		//System.out.println(".......................");
		else{
			if (mor!=(mother)){
				this.mor=(mother);
			}
			if (!mother.barn.contains(this)){
				mother.barn.add(this);
			}
		}
	}
	public void setFather(Person far){
		
		if (far.getGender()!='M' || this==far){
			throw new IllegalArgumentException("mor må være F");
		}
		else{
			if (this.far!=(far)){
				this.far=(far);
			}
			if (!far.barn.contains(this)){
				far.barn.add(this);
			}
		}
	}
	
	public String toString(){
		String barner = "";
		String mor = "";
		String far = "";
		if(getChildCount()>=1){
			for (int i=1; i<=getChildCount();i++){
				barner+=getChild(i).getName()+";"+"\n";
			}
		}
		if(getMother() != null){
			mor=getMother().getName();
		}
		if(getFather() != null){
			far = getFather().getName();
		}
		return "Navn: "+name+"; Kjønn: "+gender+"\n"+
				"Barn: "+getChildCount()+"\n"+barner+
				"Mor: "+ mor+"\n"+
				"Far: "+ far+"\n"+"#";
				
	}
}
