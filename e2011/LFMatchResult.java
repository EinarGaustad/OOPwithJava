package e2011;

/**
 * 
 * Du skal implementere klasser for å representere informasjon ifm.
 * gjennomføring av seriespill i sporter som fotball, håndball, volleyball osv.
 * Klassen MatchResult skal representere informasjon om en kamp og dens
 * resultatet, mens klassen LeagueTable skal representere et sett kamper og
 * beregne serietabellen basert på kampresultatene. I del 2 skal vi begrense
 * oss til tabeller for ferdigspilte fotballkamper.
 * 
 * a) Implementer MatchResult:
 * - Representasjon og innkapsling av informasjon om navnene på hjemme- og
 * bortelagene. Navnene
 * skal ikke kunne endres etter at et MatchResult-objekt er laget.
 * - Representasjon og innkapsling av informasjon om kampresultatet, dvs. antall
 * hjemme- og
 * bortemål.
 * - Metodene isParticipant(String participant) for å spørre om (laget)
 * participant spiller i denne
 * kampen, isDraw() for å spørre om resultatet ble uavgjort og isWinner(String
 * participant) for å spørre om (laget) participant vant denne kampen.
 * 
 * lf:
 * Her må en velge datatype for lagnavnene og målene, hhv. String og ints. Det
 * er ikke viktig hva en kaller feltene/metodenavnene, men pga. generaliseringen
 * i oppgave 3 så har vi valgt sportnøytrale navn. En bør ha én eller flere
 * metoder for å sette og/eller legge til mål. Her har vi valgt å ha én
 * metode, hvor laget som får mål angis med lagnavnet. En kan også ha en
 * metode for hvert lag.
 */

public class LFMatchResult {
    
    private final String participant1, participant2;
    private int          points1 = 0, points2 = 0;
    
    public LFMatchResult(String participant1, String participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }
    
    public String toString() {
        return participant1 + " - " + participant2 + ": " + points1 + " - "
                + points2;
    }
    
    public String getParticipant1() {
        return participant1;
    }
    
    public String getParticipant2() {
        return participant2;
    }
    
    public boolean isParticipant(String participant) {
        return participant.equals(participant1)
                || participant.equals(participant2);
    }
    
    public int getPoints(String participant) {
        if (participant.equals(participant1)) {
            return points1;
        } else if (participant.equals(participant2)) {
            return points2;
        } else {
            return -1;
        }
    }
    
    public boolean isWinner(String participant) {
        return participant.equals(participant1) && points1 > points2
                || participant.equals(participant2) && points2 > points1;
    }
    
    public boolean isDraw() {
        return points1 == points2;
    }
    
    public void addPoints(String participant, int points) {
        if (participant.equals(participant1)) {
            points1 += points;
        } else if (participant.equals(participant2)) {
            points2 += points;
        }
    }
}
