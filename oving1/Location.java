package oving1;

/***
 * 
 * @author GuoJunjun Oppgaven handler om en Location-klasse, som holder rede på
 *         x,y-posisjonen til en figur som beveger seg i et rutenett.
 *         Location-klassen har følgende metoder:
 * 
 *         up() - beveger figuren en rute opp down() - beveger figuren en rute
 *         ned left() - beveger figuren en rute til venstre right() - beveger
 *         figuren en rute til høyre Merk at konvensjonen innen datagrafikk og
 *         rutenettbaserte spill er at x øker mot høyre (som i matte) og y
 *         nedover (altså motsatt av i matte).
 * 
 *         Del 1 - tilstandsdiagram Tegn et tilstandsdiagram for en tenkt bruk
 *         av Location-klassen. Velg selv passende tilstandsvariable for
 *         x,y-posisjonen.
 * 
 *         Del 2 - Java-kode Skriv Java-kode for Location-klassen med oppførsel
 *         som beskrevet over.
 * 
 *         Lag en passende toString()-metode og et hovedprogram, slik at du kan
 *         sjekke at oppførselen stemmer med tilstandsdiagrammet (bruk samme
 *         start-tilstand og sekvens av kall).
 */
public class Location {
	
	int	x	= 0;
	int	y	= 0;

	public void up() {
		y -= 1;
	}

	public void down() {
		y += 1;
	}

	public void left() {
		x -= 1;
	}

	public void right() {
		x += 1;
	}

	public String toString() {
		return "x: " + x + "   y: " + y;
	}
}
