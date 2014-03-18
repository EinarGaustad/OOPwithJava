package oving2.Stack;

import java.util.ArrayList;

/***
 * 
 * @author GuoJunjun Oppgaven handler om en Stack-klasse, som skal lagre
 *         tilfeldige tekster i datastrukturen stack. I denne oppgaven skal vi
 *         lagre strenger i en datastruktur som heter stack. Java har en egen
 *         implementasjon av datastrukturen (java.util.Stack), men for å få en
 *         god forståelse av hvordan en stack fungerer, skal vi implementere den
 *         selv. Stack brukes ofte i programmering og det er gunstig å lære seg
 *         den tidlig. Mer informasjon om stack-datastrukturen:
 *         http://en.wikipedia.org/wiki/Stack_data_structure
 * 
 *         Vi skal lage to klasser, Stack og RandomStringGenerator, som skal gi
 *         oss tilfeldige strenger å lagre i stacken.
 * 
 *         Tilstanden i Stack-objekter er som følger:
 * 
 *         stringList - en liste med strenger av typen ArrayList<String> (del av
 *         standard Java, i pakka java.util), som skal inneholde alle
 *         String-objektene. Informasjon om operasjonene som kan utføres på den
 *         finner du her:
 *         http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html
 *         Stack-klassen din skal ha følgende metoder:
 * 
 *         void push(String) - legger argumentet på toppen av stacken. String
 *         pop() - returner og fjerner verdien på toppen av stacken. Returner
 *         null dersom stacken er tom. String peek(int) - returner verdien i
 *         stacken som står på plassen gitt i argumentet, telt fra toppen. Det
 *         vil si, peek(0) skal returnere veriden på toppen av stacken, peek(1)
 *         skal returnere verdien nest øverst i stacken osv. Verdien skal ikke
 *         fjernes av stacken. Returner null dersom argumentet er negativt eller
 *         for stort. int getSize() - returner antallet elementer i stacken.
 *         RandomStringGenerator skal generere tilfeldige String-objekter. For å
 *         få til dette kan du bruke Random-klassen i java.util-pakka og
 *         metodene nextInt() og nextInt(int):
 *         http://docs.oracle.com/javase/6/docs/api/java/util/Random.html.
 * 
 *         Tilstanden i RandomStringGenerator-objekter velger du selv, men det
 *         er naturlig å ha et felt som inneholder et Random-objekt. Du velger
 *         selv strategien for å lage tilfeldige tekster. F.eks. kan du bygge
 *         opp en String med tilfeldig lengde og tilfeldige bokstaver, du prøve
 *         å lage tilfeldige ord ved å veksle mellom vokaler og konsonanter, du
 *         kan kan sette sammen en tilfeldig sekvens av ferdiglagde ord-deler
 *         osv.
 * 
 *         RandomStringGenerator-klassen skal ha følgende metode(r):
 * 
 *         String getRandomString() - returner et tilfeldig String-objekt. Del 1
 *         - tilstandsdiagram Tegn objekttilstandsdiagram for en tenkt bruk av
 *         Stack-klassen og RandomStringGenerator-klassen. Velg selv passende
 *         start-tilstand og sekvens av kall.
 * 
 *         Del 2 - Java-kode Skriv Java-kode for Stack-klassen og
 *         RandomStringGenerator-klassen med oppførsel som er beskrevet over.
 * 
 *         Lag en passende toString()-metode for Stack-klassen og et
 *         hovedprogram, som får tilfeldige String-objekter fra et
 *         RandomStringGenerator-objekt. Bruk disse strengene til å teste
 *         Stack-klassen og sjekk at oppførselen stemmer med
 *         tilstandsdiagrammet.
 */
public class Stack {
	ArrayList<String>	list	= new ArrayList<String>();

	public void push(String steng) {
		list.add(steng);
	}

	public String pop() {
		int size = list.size();
		if (size == 0)
			return null;
		String ut = (String) list.get(size - 1);
		list.remove(size - 1);
		return ut;
	}

	public String peek(int pindex) {
		int size = getSize();
		if (size < pindex || pindex < 0 || size < 1 || size - pindex - 1 < 0) {
			return null;
		} else {
			return list.get(size - pindex - 1);
		}
	}

	public int getSize() {
		return list.size();
	}

	public String toString() {
		String ut = "";
		for (int i = 0; i < getSize(); i++) {
			ut += peek(i) + '\n';
		}
		return ut;
	}
}
