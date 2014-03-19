package oving5.Person;

import java.util.ArrayList;
import java.util.Collection;

/***
 * 
 * @author GuoJunjun Denne oppgaven handler om en Person-klasse med en
 *         1-n-assosiasjon med rollene children og mother/father til samme
 *         klasse (altså barn-mor/far-forhold) og det å sikre konsistens, slik
 *         at foreldre og barn er korrekt knyttet sammen. En viktig del av det å
 *         implementere assosiasjoner er å sikre konsistens, dvs. at objekter i
 *         hver ende av en kobling refererer korrekt til hverandre. Et eksempel
 *         på dette for 1-n-assosiasjoner er foreldreskap, hvor foreldre og barn
 *         er koblet til samme i et slektstre. I denne oppgaven skal en
 *         Person-klasse implementeres og det å legge til (og fjerne) barn
 *         håndteres korrekt, som illustrert nedenfor.
 * 
 *         Person-klassen skal inneholde informasjon om navn (en String) og
 *         kjønn (en char, 'F' eller 'M'), som bare skal kunne settes i
 *         konstruktøren, og mor, far og barn, som er andre Person-objekter.
 *         Navnet er ikke viktig for oppførselen, men er grei å ha med i en
 *         toString()-metode, for å skille Person-objektene fra hverandre.
 *         Person-klassen skal ha følgende metoder for å lese tilstanden:
 * 
 *         getName() - returnerer navnet knyttet til dette Person-objektet
 *         getGender() - returnerer tegnet som representerer kjønnet, enten 'F'
 *         eller 'M' getMother() - returnerer Person-objektet som er moren, evt.
 *         null getFather() - returnerer Person-objektet som er faren, evt. null
 *         getChildCount() - returnerer antall barn dette Person-objektet har
 *         getChild(int n) - returnerer barn nr. n (altså et Person-objekt),
 *         evt. utløser (et passende) unntak om n er for stor (eller liten)
 *         Person-klassen har to sett med endringsmetoder, knyttet til de to
 *         rollene i hver ende av children-mother/father-assosiasjonen.
 * 
 *         Fra children-perspektivet har vi følgende to metoder:
 * 
 *         addChild(Person) - oppretter en kobling til et barn (et annet
 *         Person-objekt). Dersom Person-objektet som metoden kalles på, er en
 *         kvinne, så skal denne bli barnets mor, og motsatt, dersom
 *         Person-objektet som metoden kalles på, er en mann, så skal denne bli
 *         barnets far. removeChild(Person) - fjerner en kobling til et barn (et
 *         annet Person-objekt). Dersom Person-objektet som metoden kalles på,
 *         er moren til argumentet, så skal mother-koblingen fjernes, og
 *         motsatt, dersom Person-objektet som metoden kalles på, er argumentets
 *         far, så skal father-koblingen fjernes. Fra mother/father-perspektivet
 *         har vi følgende to metoder:
 * 
 *         setMother(Person) - setter argumentet (en kvinne) som moren til
 *         Person-objektet som metoden kalles på. Argumentet får samtidig
 *         registrert Person-objektet som metoden kalles på, som sitt barn.
 *         setFather(Person) - setter argumentet (en mann) som faren til
 *         Person-objektet som metoden kalles på. Argumentet får samtidig
 *         registrert Person-objektet som metoden kalles på, som sitt barn. Det
 *         som er verd å merke seg er at begge sett med metoder,
 *         addChild/removeChild og setMother/setFather, må ha logikk som
 *         håndterer koblingen den andre veien, så addChild/removeChild må kalle
 *         setMother/setFather og omvendt, eller ha kode med tilsvarende effekt.
 *         Dette kan være nokså fiklete, fordi en både må sikre konsistens og
 *         unngå uendelig nøstede kall (inntil du får StackOverflowException).
 * 
 *         Figurene under illustrerer tilfellene som må kunne håndteres, og som
 *         testes av testene det er lenket til.
 * 
 *         Oppgaven er delt i to trinn, den første håndterer children- og
 *         mother/father-rollen isolert og uten krav om konsistens, mens det
 *         andre skal sikre konsistens.
 * 
 *         Trinn 1 Implementer addChild- og removeChild-metodene slik at
 *         getChildCount- og getChild-metodene virker som forventet. Disse
 *         metodene håndterer altså kun children-rollen. Implementer setMother-
 *         og setFather-metodene slik at getMother- og getFather-metodene virker
 *         som forventet. Disse metodene håndteres altså kun
 *         mother/father-rollen. Test metodene ved å koble opp Person-objekter
 *         tilsvarende din egen familie. Du blir nødt til å bruke de tre
 *         metodene addChild, setMother og setFather. Prøv å få med minst tre
 *         generasjoner.
 * 
 *         Trinn 2 Utvid metodene til å sikre konsistens. Test at det fortsatt
 *         virker å koble opp din egen familie, denne gangen ved å bare bruke
 *         addChild og ved å bare bruke setMother og setFather.
 */
public class Person {
	
	private Person				mor;	// Collection<Person> mor;
	private Person				far;	// Collection<Person> far;
	private Collection<Person>	barn;	// ArrayList<Person> barn;
	private String				name;
	private char				gender;
	
	// public Person(String name, char gender, String mor, String far, String
	// barn){
	
	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
		mor = null;// = new ArrayList<Person>();
		far = null;// new ArrayList<Person>();
		barn = new ArrayList<Person>();
	}
	
	public String getName() {
		return name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public Person getMother() {
		return mor;
		/*
		 * if( mor.size() == 0){ return null; } return ((ArrayList<Person>)
		 * mor).get(0);
		 */
	}
	
	public Person getFather() {
		// if( far == null){
		// return null;
		// }
		return far;
	}
	
	public Person getChild(int n) {
		if (barn.size() <= n || barn.size() < 0) {
			throw new IllegalArgumentException("feil inndata!!");
		}
		return ((ArrayList<Person>) barn).get(n);
	}
	
	public int getChildCount() {
		return barn.size();
	}
	
	public void addChild(Person child) {
		if (!barn.contains(child)) {
			barn.add(child);
		}
		if (this.gender == 'M') {
			if (child.getFather() == null) {
				child.setFather(this);
			}
		}
		if (this.gender == 'F') {
			if (child.getMother() == null) {
				child.setMother(this);
			}
		}
	}
	
	public void removeChild(Person child) {
		if (barn.contains(child)) {
			barn.remove(child);
		}
		if (this.gender == 'M') {
			if (child.getFather() != null) {
				child.far = null;
			}
		}
		if (this.gender == 'F') {
			if (child.mor == (this)) {
				child.mor = null;
			}
		}
	}
	
	public void setMother(Person mother) {
		// if( mother != null && (mother == this || mother == this.mor ||
		// (mother.gender != this.gender)))
		if (mother.getGender() != 'F' || this == mother) {
			throw new IllegalArgumentException("mor må være F");
		}
		// System.out.println(".......................");
		else {
			if (mor != (mother)) {
				this.mor = (mother);
			}
			if (!mother.barn.contains(this)) {
				mother.barn.add(this);
			}
		}
	}
	
	public void setFather(Person far) {
		
		if (far.getGender() != 'M' || this == far) {
			throw new IllegalArgumentException("mor må være F");
		} else {
			if (this.far != (far)) {
				this.far = (far);
			}
			if (!far.barn.contains(this)) {
				far.barn.add(this);
			}
		}
	}
	
	public String toString() {
		String barner = "";
		String mor = "";
		String far = "";
		if (getChildCount() >= 1) {
			for (int i = 1; i <= getChildCount(); i++) {
				barner += getChild(i).getName() + ";" + "\n";
			}
		}
		if (getMother() != null) {
			mor = getMother().getName();
		}
		if (getFather() != null) {
			far = getFather().getName();
		}
		return "Navn: " + name + "; Kjønn: " + gender + "\n" + "Barn: "
				+ getChildCount() + "\n" + barner + "Mor: " + mor + "\n"
				+ "Far: " + far + "\n" + "#";
		
	}
}
