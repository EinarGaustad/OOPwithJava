package oving8.cardcontainerimpl;

import java.util.ArrayList;

import junit.framework.AssertionFailedError;

/***
 * 
 * @author junjun Denne oppgaven handler om å lage en felles superklasse
 *         CardContainerImpl for CardDeck- og CardHand-klassene, laget i
 *         Card-oppgaven og CardContainer-oppgaven. Denne oppgaven bygger på
 *         klasser fra Card-oppgaven og CardContainer-oppgaven. Her skal du lage
 *         en superklasse CardContainerImpl, som CardDeck og CardHand skal arve
 *         fra.
 * 
 *         Del 1 - CardContainerImpl superklasse Lag en
 *         CardContainerImpl-superklasse, som implementerer grensesnittet
 *         CardContainer (se CardContainer-oppgaven) og inneholder koden som er
 *         felles for CardDeck og CardHand.
 * 
 *         La CardDeck og CardHand arve CardContainerImpl og gjør nødvendige
 *         endringer i disse klassene, slik at totaloppførselen er som før.
 *         F.eks. skal CardDeck-objektet ha samme konstruktør som før, som skal
 *         sikre samme initielle tilstand (men ikke nødvendigvis med samme
 *         konstruktør-kode).
 * 
 *         Merk at målet er at mest mulig kode skal flyttes til superklassen og
 *         gjenbrukes i subklassene. Det er viktig å bruke innkapsling rett
 *         (hint: protected-modifikatoren) for å nyttiggjøre seg superklassen i
 *         størst mulig grad.
 * 
 * 
 *         Del 2 - Regler for maksimalt antall kort Anta at en ønsker å unngå at
 *         instanser av CardContainerImpl (eller av en av subklassene)
 *         inneholder for mange kort. Legg til et privat maxCardCount-felt i
 *         CardContainerImpl og en konstruktør som initialiserer feltet. Legg så
 *         til evt. endre kode i CardContainerImpl som sikrer at antall kort
 *         ikke kan overstige dette tallet og at subklassene ikke kan omgå denne
 *         valideringen. Subklassene skal imidlertid kunne sette maks-antallet
 *         som følger: CardDeck skal sette makstallet til 52 og CardHand skal ta
 *         inn maks-antallet i sin konstruktør. Hvis man forsøker å legge til
 *         flere kort enn hva som er tillatt i CardHand, skal det utløses en
 *         IllegalStateException.
 */
public class CardContainerImpl implements CardContainer {

	private int					maxCard = 52;
	protected ArrayList<Card>	cards;

	public void maxCardCount(int maxCard) {
		this.maxCard = maxCard;
	}

	public int getMaxCardCount() {
		return maxCard;
	}

	public int getCardCount() {
		return cards.size();
	}

	public Card getCard(int n) {
        if (n >= cards.size() || n < 0) {
			throw new AssertionFailedError("feil");
		}
		return cards.get(n);
	}
}
