package oving1;

/***
 * 
 * @author GuoJunjun Oppgaven omhandler en LineEditor-klasse, som håndterer data
 *         for redigering av en linje med tekst (altså tekst uten linjeskift).
 *         LineEditor-klassen holder rede på en String-verdi og en
 *         tekstinnsettingsposisjon og har metoder for å redigere teksten.
 *         Tilstanden er som følger:
 * 
 *         text (en String-verdi) - teksten insertionIndex - heltall som angir
 *         hvor i teksten redigeringer vil skje Klassen har metoder med følgende
 *         oppførsel:
 * 
 *         void left() - flytter tekstinnsettingsposisjonen ett tegn til venstre
 *         (tilsvarende bruk av venstre piltast)
 * 
 *         void right() - flytter tekstinnsettingsposisjonen ett tegn til høyre
 *         (tilsvarende bruk av høyre piltast)
 * 
 *         void insertString(String s) - skyter teksten angitt av argumentet s
 *         inn i teksten på tekstinnsettingsposisjonen og forskyver
 *         tekstinnsettingsposisjonen mot høyre tilsvarende
 * 
 *         void deleteLeft() - fjerner tegnet til venstre for
 *         tekstinnsettingsposisjonen
 * 
 *         void deleteRight() - fjerner tegnet til høyre for
 *         tekstinnsettingsposisjonen Del 1 - tilstandsdiagram Tegn et
 *         tilstandsdiagram for en tenkt bruk av LineEditor-klassen, som dekker
 *         bruk av alle metodene.
 * 
 *         For alle metodene bør du tenke på hva som er fornuftig oppførsel for
 *         spesielle tilfeller, f.eks. når tekstinnsettingsposisjonen er helt
 *         til venstre eller høyre. Tenk også på hva som bør skje med
 *         tekstinnsettingsposisjonen når teksten endres.
 * 
 *         Del 2 - Java-kode Skriv Java-kode for LineEditor-klassen med
 *         oppførsel som beskrevet over.
 * 
 *         Lag en toString()-metode som viser teksten med tegnet '|' skutt inn
 *         på tekstinnsettingsposisjonen. Lag så et hovedprogram, slik at du kan
 *         sjekke at oppførselen stemmer med tilstandsdiagrammet (bruk samme
 *         start-tilstand og sekvens av kall).
 * 
 *         JExercise-testkode for oppgaven finner du her:
 *         stateandbehavior/LineEditorTest.java
 * 
 *         Del 3 - frivillige utvidelser Legg til metoden void insert(Object o),
 *         som skyter inn en tekstlig representasjon av objektet o som gis som
 *         argument. Legg til metoden void left(int n), som flytter
 *         tekstinnsettingsposisjonen n tegn til venstre, og skriv om left() til
 *         å bruke denne. Hva bør skje dersom tekstinnsettingsposisjonen er
 *         mindre enn n? Legg til metoden right(int n), som flytter
 *         tekstinnsettingsposisjonen n tegn til høyre, og skriv om right() til
 *         å bruke denne. Hva bør skje dersom det er færre enn n tegn til høyre
 *         for tekstinnsettingsposisjonen? Utvid tilstanden og legg til metoder
 *         for å håndtere markering av region, tilsvarende bruk av shift og
 *         piltaster i en vanlig teksteditor. Husk at også de eksisterende
 *         metodene må endres til å håndtere dette riktig.
 */
public class LineEditor {
	String	text;
	int		insertionIndex;

	public LineEditor(String text, int insertionIndex) {
		this.text = text;
		this.insertionIndex = insertionIndex;
		this.sjekkInsert();
	}

	public LineEditor(String text) {
		this.text = text;
		insertionIndex = 0;
	}

	public LineEditor() {
		text = "";
		insertionIndex = 0;
	}

	public void left() {
		insertionIndex -= 1;
		this.sjekkInsert();
	}

	public void right() {
		insertionIndex += 1;
		sjekkInsert();
	}

	public void insertString(String s) {
		String nyText = "";
		nyText += text.substring(0, insertionIndex);
		nyText += s;
		nyText += text.substring(insertionIndex, text.length());
		text = nyText;
		insertionIndex += s.length();
	}

	public void deleteLeft() {
		if (this.text.length() <= 1) {
			this.text = "";
			insertionIndex = 0;
		} else if (insertionIndex > 0 && text.length() > 1) {
			String nyText = "";
			nyText += text.substring(0, insertionIndex - 1);
			nyText += text.substring(insertionIndex);
			text = nyText;
			left();
		}
	}

	public void deleteRight() {
		if (insertionIndex < text.length()) {
			String nyText = "";
			nyText += text.substring(0, insertionIndex);
			nyText += text.substring(insertionIndex + 1, text.length());
			text = nyText;
		}
	}

	public String toString() {

		return text.substring(0, insertionIndex) + "|"
				+ text.substring(insertionIndex, text.length());
	}

	public void sjekkInsert() {
		if (insertionIndex < 0)
			insertionIndex = 0;
		else if (insertionIndex > text.length())
			insertionIndex = text.length();
	}
}
