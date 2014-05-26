package e2011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * b) Implementer LeagueTable:
 * - Representasjon av (navnene til) alle lagene. Navnene skal ikke kunne endres
 * etter at
 * LeagueTable-objektet er laget.
 * - Representasjon av informasjon om kampresultater, dvs. MatchResult-objekter.
 * Det skal kun
 * være lov å legge inn nye kamper, ikke fjerne dem. Det skal ikke være lov å
 * legge inn kamper for
 * lag som ikke er med i tabellen.
 * - Metoden getParticipantPoints(MatchResult matchResult, String participant)
 * som returnerer
 * antall poeng som (laget) participant fikk for resultatet matchResult. Ta
 * høyde for at participant faktisk ikke er med i matchResult.
 * 
 * Tabellpoeng summeres basert på kampresultatene, og tabellen sorteres etter
 * antall poeng, med laget med flest poeng øverst. Når et kampresultat legges
 * inn, så skal tabellen oppdateres.
 * 
 * Merk at du antageligvis vil trenge en klasse for å representere hver rad i
 * tabellen, f.eks. kalt LeagueTableRow, som lagrer data om et lag og summen av
 * poengene laget har fått for seier og uavgjort i sine kamper. Denne klassen
 * kan implementere relevante grensesnitt ifm. sortering.
 * 
 * Nedenfor er en rett frem implementasjon av tabellraden. Denne implementerer
 * Comparable- grensesnittet for å støtte sortering med Java sin sort-metode og
 * har derfor metoden compareTo. Merk at logikken er slik at objektet som skal
 * sorteres som først i en liste logisk sett må være minst og derfor returnere
 * < 0 i sammenligningen.
 * 
 * 
 * Tabell-klassen må ha en konstruktør som tar inn navnene til lagene. Det er
 * naturlig å opprette én tabellrad for hvert lag og en trenger ikke å huske
 * navnene, siden de ligger i radene. En må ha en metode for å legge til et
 * resultat som oppdaterer antall poeng for hvert lag og sorterer i etterkant.
 * Innkapsling av radene, dvs. at en har metoder for å lese radene, er ikke så
 * sentralt. Det kan gjøres på ulike måter og her gjør vi det enkelt med en
 * iterator()-metode. (Siden vi har iterator()-metoden så har vi markert at
 * klassen implementerer Iterable, men det er ikke viktig.)
 */
public abstract class LFLeagueTable implements LFMatchListener,
        Iterable<LFLeagueTableRow> {
    
    private List<LFMatchResult>    matchResults;
    private List<LFLeagueTableRow> tableRows;
    
    protected LFLeagueTable(List<String> participantNames) {
        this.matchResults = new ArrayList<LFMatchResult>();
        this.tableRows = new ArrayList<LFLeagueTableRow>();
        for (String participant : participantNames) {
            tableRows.add(new LFLeagueTableRow(participant));
        }
    }
    
    private LFLeagueTableRow findEntry(String participant) {
        for (LFLeagueTableRow entry : tableRows) {
            if (entry.getParticipant().equals(participant)) {
                return entry;
            }
        }
        return null;
    }
    
    public Iterator<LFLeagueTableRow> iterator() {
        return tableRows.iterator();
    }
    
    public int getParticipantPoints(LFMatchResult match, String participant) {
        if (match.isWinner(participant)) {
            return 3;
        } else if (match.isParticipant(participant) && match.isDraw()) {
            return 1;
        }
        return 0;
    }
    
    public void addPoints(LFMatchResult matchResult, String participant) {
        findEntry(participant).addPoints(
                getParticipantPoints(matchResult, participant));
    }
    
    public void addMatchResult(LFMatchResult matchResult){
        if (findEntry(matchResult.getParticipant1()) == null
                || findEntry(matchResult.getParticipant2()) == null) {
            throw new IllegalArgumentException("Both teams must be part of the league");
        }
        matchResults.add(matchResult);
        addPoints(matchResult, matchResult.getParticipant1());
        addPoints(matchResult, matchResult.getParticipant2());
        Collections.sort(tableRows);
    }
}
